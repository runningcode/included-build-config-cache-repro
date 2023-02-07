# Included builds and configuration cache


This build reproduces a problem with the configuration cache and included builds.

## Steps to reproduce
On a fresh checkout, executing `assemble` will fail with an error storing the configuration cache.

If you are not on a fresh checkout, you can reproduce the error with the following steps:
```
rm -r .gradle/configuration-cache
rm -r included-build/example/build
```

Here is the error storing to the configuration cache:

```
> Task :included-build:example:kaptKotlin FAILED

FAILURE: Build completed with 2 failures.

1: Task failed with an exception.
-----------
* What went wrong:
Execution failed for task ':included-build:example:kaptKotlin'.
> A failure occurred while executing org.jetbrains.kotlin.gradle.internal.KaptWithoutKotlincTask$KaptExecutionWorkAction
   > java.lang.reflect.InvocationTargetException (no error message)

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
==============================================================================

2: Task failed with an exception.
-----------
* What went wrong:
Configuration cache problems found in this build.

1 problem was found storing the configuration cache.
- Task `:included-build:example:kaptGenerateStubsKotlin` of type `org.jetbrains.kotlin.gradle.internal.KaptGenerateStubsTask`: invocation of 'Task.project' at execution time is unsupported.
  See https://docs.gradle.org/7.6/userguide/configuration_cache.html#config_cache:requirements:use_project_during_execution

See the complete report at file:///Users/no/workspace/included-build-config-cache-repro/build/reports/configuration-cache/3xe1w9rtt0luzii6fbexzmzgj/apecscr83qx9in8igbfc1l4t/configuration-cache-report.html
> Invocation of 'Task.project' by task ':included-build:example:kaptGenerateStubsKotlin' at execution time is unsupported.

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
==============================================================================
```
[You can also read the configuration cache report here.](/configuration-cache-report.html)

When running `assemble` the following error occurs:
[Here is a scan](https://scans.gradle.com/s/f3zwvnkhochju)
```
Configuration cache is an incubating feature.
Reusing configuration cache.
> Task :included-build:example:kaptGenerateStubsKotlin FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':included-build:example:kaptGenerateStubsKotlin'.
> Error while evaluating property 'verbose' of task ':included-build:example:kaptGenerateStubsKotlin'.
   > GradleProperties has not been loaded yet.
```

Subsequent builds without configuration cache enabled may fail with the following error when running `assemble`.
[Here is a scan](https://scans.gradle.com/s/x5ms6o4mwofzq/failure#1)
```
* What went wrong:
Execution failed for task ':included-build:example:kaptKotlin'.
> A failure occurred while executing org.jetbrains.kotlin.gradle.internal.KaptWithoutKotlincTask$KaptExecutionWorkAction
   > java.lang.reflect.InvocationTargetException (no error message)
```