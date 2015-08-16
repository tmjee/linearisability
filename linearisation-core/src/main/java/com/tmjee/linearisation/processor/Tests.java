package com.tmjee.linearisation.processor;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tmjee
 */
public class Tests {

    public static final String TESTS_LOCATION = "/META-INF/linearisation_tests.xml";

    private static volatile Map<String, Test> tests;

    public static Map<String, Test> getAll() {
        return getAll(TESTS_LOCATION);
    }

    static Map<String, Test> getAll(String location) {
        Map<String, Test> m = tests;
        if (m == null) {

            m = new LinkedHashMap<>();

            try (InputStream is = Test.class.getResourceAsStream(location)) {
                DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();


                Document document = documentBuilder.parse(is);
                NodeList testsNodeList = document.getElementsByTagName("linearisation-test");

                addTest(m, testsNodeList);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            tests = Collections.unmodifiableMap(m);
        }
        return tests;
    }

    public static Map<String, Test> getByClass(List<String> testClasses) {
        Map<String, Test> _m = getAll();
        Map<String, Test> r =
            Collections.unmodifiableMap(
                _m.entrySet().stream()
                    .filter((e)->testClasses.contains(e.getKey()))
                    .collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue())));
        return r;
    }


    private static void addTest(Map<String, Test> testsMap, NodeList testsNodelist) {
        int testsNodeLength = testsNodelist.getLength();
        for (int a=0;  a<testsNodeLength; a++) {

            String name = null, description = null, testClassName = null, testPackageName = null;

            Test.Builder builder = new Test.Builder();

            Node testNode = testsNodelist.item(a);
            NodeList testNodeList = testNode.getChildNodes();
            int testNodeLength = testNodeList.getLength();

            for (int b=0; b<testNodeLength; b++) {
                Node testInternalNode = testNodeList.item(b);
                String testInternalNodeName = testInternalNode.getNodeName();

                    if ("name".equals(testInternalNodeName)) {
                        name = testInternalNode.getTextContent();
                    } else if ("description".equals(testInternalNodeName)) {
                        description = testInternalNode.getTextContent();
                    } else if ("testPackageName".equals(testInternalNodeName)) {
                        testPackageName = testInternalNode.getTextContent();
                    } else if ("testClassName".equals(testInternalNodeName)) {
                        testClassName = testInternalNode.getTextContent();
                    } else if ("testMethods".equals(testInternalNodeName)) {
                        addTestMethod(builder, testInternalNode);
                    } else if ("consequences".equals(testInternalNodeName)) {
                        addConsequences(builder, testInternalNode);
                    } else if ("references".equals(testInternalNodeName)) {
                        addReferences(builder, testInternalNode);
                    } else if ("runner".equals(testInternalNodeName)) {
                        addRunner(builder, testInternalNode);
                    } else if ("invariant".equals(testInternalNodeName)) {
                        addInvariant(builder, testInternalNode);
                    } else if ("record".equals(testInternalNodeName)) {
                        addRecord(builder, testInternalNode);
                    }
            }
            builder.withName(name)
                    .withTestClass(testPackageName, testClassName)
                    .withDescription(description);

            Test test = builder.build();

            testsMap.put(test.testClass().className, test);
        }
    }


    private static void addTestMethod(Test.Builder builder, Node testMethodsNode) {
        /**
         * <testMethods>
         *      <testMethod>
         *          ...
         *      </testMethod>
         * </testMethods>
         */
        NodeList testMethodNodeList = testMethodsNode.getChildNodes();
        int testMethodNodeListLength = testMethodNodeList.getLength();

        for (int a=0; a<testMethodNodeListLength; a++) {

            Node _testMethodNode = testMethodNodeList.item(a);
            String _testMethodNodeName = _testMethodNode.getNodeName();

            if ("testMethod".equals(_testMethodNodeName)) {

                NodeList _nodeList = _testMethodNode.getChildNodes();
                int _length = _nodeList.getLength();

                String methodName = null;
                String arg0 = null;
                String arg1 = null;

                for (int b = 0; b < _length; b++) {
                    Node testMethodNode = _nodeList.item(b);
                    String testMethodNodeName = testMethodNode.getNodeName();

                    if ("methodName".equals(testMethodNodeName)) {
                        methodName = testMethodNode.getTextContent();
                    } else if ("arg0".equals(testMethodNodeName)) {
                        arg0 = testMethodNode.getTextContent();
                    } else if ("arg1".equals(testMethodNodeName)) {
                        arg1 = testMethodNode.getTextContent();
                    }
                }
                builder.addTestMethod(methodName, new String[]{arg0, arg1});
            }
        }
    }


    private static void addConsequences(Test.Builder builder, Node consequencesNode) {
        /**
         * <consequences>
         *     <consequence>
         *         ...
         *     </consequence>
         * </consequences>
         */
        NodeList consequenceNodeList = consequencesNode.getChildNodes();
        int consequenceNodeListLength = consequenceNodeList.getLength();

        String id = null;
        Expectation expectation = null;
        String description = null;

        for (int a=0; a< consequenceNodeListLength; a++) {
            Node consequenceNode = consequenceNodeList.item(a);
            NodeList contentNodeList = consequenceNode.getChildNodes();
            int contentNodeListLength = contentNodeList.getLength();
            for (int b=0; b< contentNodeListLength; b++) {
                Node contentNode = contentNodeList.item(b);
                String contentNodeName = contentNode.getNodeName();

                if ("id".equals(contentNodeName)) {
                    id = contentNode.getTextContent();
                } else if ("expectation".equals(contentNodeName)) {
                    expectation = Expectation.valueOf(contentNode.getTextContent());
                } else if ("description".equals(contentNodeName)) {
                    description = contentNode.getTextContent();
                }
            }
            builder.addConsequence(id, expectation, description);
        }
    }

    private static void addReferences(Test.Builder builder, Node referencesNode) {
        /**
         * <references>
         *      <reference>...</reference>
         * </references>
         */
        NodeList referenceNodeList = referencesNode.getChildNodes();
        int referenceNodeListLength = referenceNodeList.getLength();
        for (int a=0; a<referenceNodeListLength; a++) {
            Node referenceNode = referenceNodeList.item(a);
            String referenceNodeName = referenceNode.getNodeName();
            if ("reference".equals(referenceNodeName)) {
                String reference = referenceNode.getTextContent();
                builder.addReference(reference.trim());
            }
        }
    }

    private static void addRunner(Test.Builder builder, Node runnerNode) {
        /**
         * <runner>
         *     ...
         * </runner>
         */
        NodeList runnerChildNodeList = runnerNode.getChildNodes();
        int runnerChildNodeListLength = runnerChildNodeList.getLength();

        String packageName = null;
        String className = null;

        for (int a=0; a<runnerChildNodeListLength; a++) {
            Node runnerChilldNode = runnerChildNodeList.item(a);
            String runnerChildNodeName = runnerChilldNode.getNodeName();
            if ("packageName".equals(runnerChildNodeName)) {
                packageName = runnerChilldNode.getTextContent();
            } else if ("className".equals(runnerChildNodeName)) {
                className = runnerChilldNode.getTextContent();
            }
        }
        builder.withRunner(packageName, className);
    }

    private static void addInvariant(Test.Builder builder, Node invariantNode) {
        /**
         * <invariant>
         *     ...
         * </invariant>
         */
        NodeList invariantChildNodeList = invariantNode.getChildNodes();
        int invariantChildNodeListLength = invariantChildNodeList.getLength();

        String packageName = null;
        String className = null;

        for (int a=0; a<invariantChildNodeListLength; a++) {
            Node invariantChildNode = invariantChildNodeList.item(a);
            String invariantChildNodeName = invariantChildNode.getNodeName();
            if ("packageName".equals(invariantChildNodeName)) {
                packageName = invariantChildNode.getTextContent();
            } else if ("className".equals(invariantChildNodeName)) {
                className = invariantChildNode.getTextContent();
            }
        }
        builder.withInvariant(packageName, className);
    }

    private static void addRecord(Test.Builder builder, Node recordNode) {
        /**
         * <record>
         *     ...
         * </record>
         */
        NodeList recordChildNodeList = recordNode.getChildNodes();
        int recordChildNodeListLength = recordChildNodeList.getLength();

        String packageName = null;
        String className = null;

        for (int a=0; a<recordChildNodeListLength; a++) {
            Node recordChildNode = recordChildNodeList.item(a);
            String recordChildNodeName = recordChildNode.getNodeName();
            if ("packageName".equals(recordChildNodeName)) {
                packageName = recordChildNode.getTextContent();
            } else if ("className".equals(recordChildNodeName)) {
                className = recordChildNode.getTextContent();
            }
        }
        builder.withRecord(packageName, className);
    }


}
