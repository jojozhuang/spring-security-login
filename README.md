# spring-security-login
Admin page with spring security, built with spring boot and gradle in Java.

Default users:
- johnny/abc123
- admin/abc123

## Run sonarqube locally
```shell
./gradlew build sonarqube --info
```
- Run with `--stacktrace` option to get the stack trace.
- Run with `--debug` option to get more log output.
- Run with `--scan` to get full insights.

## Generate Hashed Password
Generate bcrypt hash value for `abc123`.
```shell
$ spring encodepassword abc123 
{bcrypt}$2a$10$1TJR4iu6C8K5ICi3MnD1Cu0nYfzYPo92x81mxqTfmfnruoTrz.dvG
```
