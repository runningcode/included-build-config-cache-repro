# Gradle 8.0-rc-3 issue.


This build reproduces a problem with Gradle 8.0-rc-3.



## Steps to reproduce
On a fresh checkout, executing `assemble` will fail.

[Here is a scan](https://scans.gradle.com/s/oq6qzzjtelkuo/failure#1)

```
A failure occurred while executing org.jetbrains.kotlin.gradle.internal.KaptWithoutKotlincTask$KaptExecutionWorkAction
> (No message provided)
  > (No message provided)
    > java.lang.IllegalStateException: Could not parse metadata! Try bumping kotlinpoet and/or kotlinx-metadata version.
      > Could not parse metadata! Try bumping kotlinpoet and/or kotlinx-metadata version.
```