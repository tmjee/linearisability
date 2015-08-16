# Building Linearisation

## Prerequisite
- JDK 8
- Maven 3.x
- Git


## Building from source
- Checkout code
```
    $> git clone https://github.com/tmjee/linearisability.git
```
- Compile & build
```
    $> mvn clean install
```
- Run linearisation tests (in linearisation-sample maven sub-module that comes with the checkout )
```
    $> cd scripts/
    $> ./run_sample_allTests.sh
```

