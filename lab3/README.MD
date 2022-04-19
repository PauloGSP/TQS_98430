# a)
-A_EmployeeRepositoryTest
```
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
```
-E_EmployeeRestControllerTemplateIT (two examples in this file)
```
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");
```

# b)

The file B_EmployeeService_UnitTest.java has a function called setUp that examplifies this behavior with a Mockito mock.

# C)

@MockBean we write a test that is backed by a Spring Test Context and is capable of functioning at class or field level.

@Mock can provide simpler debugging because it ties the field name and the mock itself. It also allows for shorthand mock creation.

# d)

In application-integrationtest.properties we can set all properities that allow for connections with exterior services like databases, its also in this file we put the credentials for such services (funtions in a similar way to the application.properties file).

# e)

Test C- Creates a mock of every service and access to the API. 
Test D- Allows for testing of every bean by encapsulating them.
Test E- Tests every component without mocks.
