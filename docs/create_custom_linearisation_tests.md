# Create Custom Linearisation Tests

## Prerequisite
- JDK 8
- Maven 3.x


## Creating custom Linearisation
* Create maven project
    * with `MANIFEST.MF` containing `Main-Class` entry as `com.tmjee/linearisation`. This can be done with the
    following plugin

```
     <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>${shade.plugin.version}</version>
        <executions>
             <execution>
                 <id>main</id>
                 <phase>package</phase>
                 <goals>
                     <goal>shade</goal>
                 </goals>
                 <configuration>
                     <finalName>linearisation-sample</finalName>
                     <transformers>
                         <transformer
                             implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                              <mainClass>com.tmjee.linearisation.processor.Main</mainClass>
                         </transformer>
                      </transformers>
                  </configuration>
             </execution>
        </executions>
     </plugin>
```

    * use the following plugin to compile using JDK 8

```
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>${compiler.plugin.version}</version>
					<configuration>
						<source>1.8</source>
						<target>1.8</target>
						<encoding>UTF-8</encoding>
						<compilerArgument>-XDignore.symbol.file</compilerArgument>
						<!--compilerArgument>-DCachingArchiveProvider.disableCtSym=true</compilerArgument-->
					</configuration>
				</plugin>
```

    * with the following dependency

```
        <dependency>
            <groupId>com.tmjee.linearisation</groupId>
            <artifactId>linearisation-core</artifactId>
            <version>${project.version}</version>
        </dependency>
```

## Write Linearisation tests
```java
    @Linearisation
    @Consequence(id="[0]", expectation=Expectation.ACCEPTABLE, description=""
    @Ref("https://github.com/tmjee/linearisability/blob/master/docs/results/create_custom_linearisation_tests.md")
    public class MyLinearisationTest {

        @Invariant
        public static class MyState {
            volatile List<Integer> myLockFreeThreadSafeList = new MyLockFreeThreadSafeList();
        }


        @Record
        public class MyIntResult1 {
            public volatile int value1;

            @Override
            public String toString() {
                return format("[%s]", value1);
            }
        }


        @TestUnit(name="myLinearisationTest" description="This is my Linearisation test")
        public static class TestUnit1 {
            @Player
            public void player1(MyState state, MyIntResult1 result) {
                // the state and result objects will be the same for both player 1 and 2
            }

            @Player
            public void player2(MyState state, IntResult1 result) {
                // the state and result objects will be the same for both player 1 and 2
            }
        }
    }
```

## Compile code, to generate java and class files and meta data xml file

```
    $> mvn clean install
```

## Run code

### To run all tests
```
    $> java -cp linearisation-core.jar:myLinearisationTests.jar -jar myLinearisationTests.jar
```

### To run just one test
```
    $> java -cp linearisation-core.jar:myLinearisationTests.jar -jar myLinearisationTests.jar \
    -testClasses=MyLinearisationTest.TestUnit1
```
### To change options
```
    $> java -cp linearisation-core.jar:myLinearisationTests.jar -jar myLinearisationTest.jar \
    -iterations=10  \
    -minStridesPerIteration=100 \
    -maxStridesPerIteration=100000 \
    -time=8000 \
    -userCpu=4 \
    -testClasses=MyLinearisationTest.TestUnit1
```