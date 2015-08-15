package com.tmjee.linearisation.processor;

import java.util.*;

/**
 * @author tmjee
 */
public class Test {

    private final String name;
    private final String description;
    private final ClassInfo runner;
    private final ClassInfo invariant;
    private final ClassInfo record;
    private final ClassInfo testClass;
    private final List<MethodInfo> testMethods;
    private final Set<Consequence> consequences;
    private final List<String> references;

    private Test(String name, String description, ClassInfo runner, ClassInfo invariant, ClassInfo record,
                 ClassInfo testClass, List<MethodInfo> testMethods, Set<Consequence> conseqeunces,
                 List<String> references) {
        this.name = name;
        this.description = description;
        this.runner = runner;
        this.invariant = invariant;
        this.record = record;
        this.testMethods = testMethods;
        this.testClass = testClass;
        this.consequences = Collections.unmodifiableSet(conseqeunces);
        this.references = Collections.unmodifiableList(references);
    }

    public String name() { return name; }
    public String description() { return description; }
    public ClassInfo runner() { return runner; }
    public ClassInfo invariant() { return invariant; }
    public ClassInfo record() { return record; }
    public Set<Consequence> consequences() { return consequences; }
    public List<String> references() { return references; }
    public List<MethodInfo> testMethods() { return testMethods; }
    public ClassInfo testClass() { return testClass; }
    public int testsCount() { return testMethods.size(); }


    /**
     * @author tmjee
     */
    public static class Consequence {
        private final String id;
        private final Expectation expectation;
        private final String description;

        public Consequence(String id, Expectation expectation, String description) {
            this.id = id;
            this.expectation = expectation;
            this.description = description;
        }

        public String id() { return id; }
        public Expectation expectation() { return expectation; }
        public String description() { return description; }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Test:");
        sb.append("\n\tname="+name);
        sb.append("\n\tdescription="+description);
        sb.append("\n\trunner="+runner);
        sb.append("\n\tinvariant="+invariant);
        sb.append("\n\trecord="+record);
        sb.append("\n\tconsequence="+consequences);
        sb.append("\n\treferences="+references);
        sb.append("\n\ttestMethods="+testMethods);
        sb.append("\n\ttestClass="+testClass);
        sb.append("]");
        return sb.toString();

    }

    /**
     * @author tmjee
     */
    public static class ClassInfo {
        protected final String packageName;
        protected final String className;

        public ClassInfo(String packageName, String className) {
            this.packageName = packageName;
            this.className = className;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("[ClassInfo:");
            sb.append("\n\tpackageName="+packageName);
            sb.append("\n\tclassName="+className);
            return sb.toString();
        }

        public String packageName() {
            return packageName;
        }
        public String className() {
            return className;
        }
    }


    /**
     * @author tmjee
     */
    public static class MethodInfo {
        private final String methodName;
        private final String arg0;
        private final String arg1;

        public MethodInfo(String methodName, String arg0, String arg1) {
            this.methodName = methodName;
            this.arg0 = arg0;
            this.arg1 = arg1;
        }

        public String methodName() { return methodName; }
        public String arg0() { return arg0; }
        public String arg1() { return arg1; }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("[ClassInfo:");
            sb.append("\n\tmethodName="+methodName);
            sb.append("\n\targ0="+arg0);
            sb.append("\n\targ1="+arg1);
            return sb.toString();
        }
    }


    /**
     * @author tmjee
     */
    public static class Builder {
        private String name;
        private String description;
        private ClassInfo runner;
        private ClassInfo invariant;
        private ClassInfo record;
        private ClassInfo testClass;
        private List<MethodInfo> testMethods = new ArrayList<MethodInfo>();
        private Set<Consequence> consequences = new LinkedHashSet<>();
        private List<String> references = new ArrayList<>();

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withRunner(String runnerPackageName, String runnerClassName) {
            this.runner = new ClassInfo(runnerPackageName, runnerClassName);
            return this;
        }

        public Builder withInvariant(String invariantPackageName, String invariantClassName) {
            this.invariant = new ClassInfo(invariantPackageName, invariantClassName);
            return this;
        }

        public Builder withTestClass(String testPackageName, String testClassName) {
            this.testClass = new ClassInfo(testPackageName, testClassName);
            return this;
        }

        public Builder addTestMethod(String testMethodName, String[] args) {
            this.testMethods.add(new MethodInfo(testMethodName,
                    args != null && args.length >= 1 ? args[0] : null,
                    args != null && args.length >= 2 ? args[1] : null));
            return this;
        }

        public Builder addConsequence(String id, Expectation expectation, String description) {
            this.consequences.add(new Consequence(id, expectation, description));
            return this;
        }

        public Builder withRecord(String recordPackageName, String recordClassName) {
            this.record = new ClassInfo(recordPackageName, recordClassName);
            return this;
        }

        public Builder addReference(String reference) {
            this.references.add(reference);
            return this;
        }

        public Test build() {
            return new Test(name, description, runner, invariant, record, testClass, testMethods, consequences, references);
        }
    }
}
