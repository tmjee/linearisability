<?xml encoding="UTF-8" version="1.0"?>
<!--
    #
    # Auto generated by Linearisation. Do not modify, changes will be overriden.
    #
-->
<linearisation-tests>
   <#list tests as test>
   <linearisation-test>
       <name>${test.name()}</name>
       <description>${test.description()}</description>
       <testPackageName>${test.testClass().packageName()}</testPackageName>
       <testClassName>${test.testClass().className()}</testClassName>
       <testMethods>
           <#list test.testMethods() as testMethod>
           <testMethod>
               <methodName>${testMethod.methodName()}</methodName>
               <arg0>${testMethod.arg0()}</arg0>
               <arg1>${testMethod.arg1()}</arg1>
           </testMethod>
           </#list>
       </testMethods>
       <consequences>
           <#list test.consequences() as consequence>
           <consequence>
               <id>${consequence.id()}</id>
               <expectation>${consequence.expectation().name()}</expectation>
               <description>${consequence.description()}</description>
           </consequence>
           </#list>
       </consequences>
       <references>
           <#list test.references() as reference>
           <reference>${reference}</reference>
           </#list>
       </references>
       <runner>
           <packageName>${test.runner().packageName()}</packageName>
           <className>${test.runner().className()}</className>
       </runner>
       <invariant>
           <packageName>${test.invariant().packageName()}</packageName>
           <className>${test.invariant().className()}</className>
       </invariant>
       <record>
           <packageName>${test.record().packageName()}</packageName>
           <className>${test.record().className()}</className>
       </record>
   </linearisation-test>
   </#list>
</linearisation-tests>
