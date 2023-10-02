# Java Utils

<p align="center">
    <p align="center">
        <a href="https://github.com/zzh1991/Java-Util/blob/master/LICENSE"><img src="https://img.shields.io/github/license/zzh1991/Java-Util.svg" alt="MIT"></a>
        <a href="https://snyk.io//test/github/zzh1991/Java-Util?targetFile=pom.xml"><img src="https://snyk.io//test/github/zzh1991/Java-Util/badge.svg?targetFile=pom.xml" alt="Known Vulnerabilities" data-canonical-src="https://snyk.io//test/github/zzh1991/Java-Util?targetFile=pom.xml" style="max-width:100%;"></a>
    </p>
    <p align="center">
        Useful utils for Java application<br>
    </p>
</p>

## java util map

![java-util](java-util.png)

### Maven package

```bash
./mvnw clean package
```

### [Java Doc](https://blog.zzhpro.com/Java-Util/)

```bash
./mvnw javadoc:javadoc
```

### Maven deploy

```bash
./mvnw deploy
```

## Todo

- [x] [maven package in GitHub](https://github.com/zzh1991/Java-Util/packages/)
- [x] Java API Doc
- [x] Utils Mind Map

## Build artifacts

> Now using GitGub Action to deploy the newest package.

Intellij IDEA
```
1. Project Structure
2. Project Settings -> Artifacts
3. + -> Jar -> From modules with dependencies
4. Build -> Build Artifa
cts
```

## How to use

```
<repositories>
    <id>github</id>
    <name>GitHub zzh1991 Apache Maven Packages</name>
    <url>https://maven.pkg.github.com/zzh1991/java-util</url>
</repositories>

<dependency>
  <groupId>com.zzh.util</groupId>
  <artifactId>java-util</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

## Author

👤 **Zhihao Zhang**

- Github: [@zzh1991](https://github.com/zzh1991)

## Show your support

Please ⭐️ this repository if this project helped you!

## 📝 License

Copyright © 2019-2023 [zzh1991](https://github.com/zzh1991).<br />
This project is [MIT](https://github.com/zzh1991/Java-Util/blob/master/LICENSE) licensed.
