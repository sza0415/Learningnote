# Maven

Maven是apache旗下的一个开源项目，是一款用于管理和构建java项目的工具，它基于项目对象模型（POM，project object model）的概念，通过一小段描述信息来guan

Maven的作用：

- 方便快捷地管理项目依赖地资源jar包，避免版本冲突问题

- 提供统一、标准地项目结构

  - 一个使用Maven管理的普通的Java项目，它的目录结构默认如下：

  - ```xml
    a-maven-project
    ├── pom.xml
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   └── resources
    │   └── test
    │       ├── java
    │       └── resources
    └── target
    ```

  - 项目的根目录`a-maven-project`是项目名，它有一个项目描述文件`pom.xml`，存放Java源码的目录是`src/main/java`，存放资源文件的目录是`src/main/resources`，存放测试源码的目录是`src/test/java`，存放测试资源的目录是`src/test/resources`，最后，所有编译、打包生成的文件都放在`target`目录里。这些就是一个Maven项目的标准目录结构。

    所有的目录结构都是约定好的标准结构，我们千万不要随意修改目录结构。使用标准结构不需要做任何配置，Maven就可以正常使用。

  - 最关键的一个项目描述文件`pom.xml`，它的内容长得像下面：

  - 

  - ```xml
    <project ...>
    	<modelVersion>4.0.0</modelVersion>
    	<groupId>com.itranswarp.learnjava</groupId>
    	<artifactId>hello</artifactId>
    	<version>1.0</version>
    	<packaging>jar</packaging>
    	<properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    		<maven.compiler.release>17</maven.compiler.release>
    	</properties>
    	<dependencies>
            <dependency>
                <groupId>org.slf4j</groupId>
                <artifactId>slf4j-simple</artifactId>
                <version>2.0.16</version>
            </dependency>
    	</dependencies>
    </project>
    ```

    其中，`groupId`类似于Java的包名，通常是公司或组织名称，`artifactId`类似于Java的类名，通常是项目名称，再加上`version`，一个Maven工程就是由`groupId`，`artifactId`和`version`作为唯一标识。

    我们在引用其他第三方库的时候，也是通过这3个变量确定。例如，依赖`org.slfj4:slf4j-simple:2.0.16`：

    ```xml
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>2.0.16</version>
    </dependency>
    ```

    使用`<dependency>`声明一个依赖后，Maven就会自动下载这个依赖包并把它放到classpath中。

    另外，注意到`<properties>`定义了一些属性，常用的属性有：

    - `project.build.sourceEncoding`：表示项目源码的字符编码，通常应设定为`UTF-8`；
    - `maven.compiler.release`：表示使用的JDK版本，例如`21`；
    - `maven.compiler.source`：表示Java编译器读取的源码版本；
    - `maven.compiler.target`：表示Java编译器编译的Class版本。

    从Java 9开始，推荐使用`maven.compiler.release`属性，保证编译时输入的源码和编译输出版本一致。如果源码和输出版本不同，则应该分别设置`maven.compiler.source`和`maven.compiler.target`。

    通过`<properties>`定义的属性，就可以固定JDK版本，防止同一个项目的不同的开发者各自使用不同版本的JDK。

- 标准跨平台（Linux、Windows、MacOS）的自动化项目构建方式

  - 清理clean-->编译compile-->测试test-->打包package-->发布
  - 生成的文件会在target当中

  ![image-20241030162835233](Spring.assets/image-20241030162835233.png)

​	安装步骤：

1. 解压apache-maven-3.9.9-bin.zip 

2. 配置本地仓库，修改conf/setting.xml中的localRepository

   ```xml
     <!-- localRepository
      | The path to the local repository maven will use to store artifacts.
      |
      | Default: ${user.home}/.m2/repository
     <localRepository>/path/to/local/repo</localRepository>
     -->
     <localRepository>D:\APP\apache-maven-3.9.9-bin\apache-maven-3.9.9\mvn_repo</localRepository>
   ```

3. 配置阿里云的私服，修改con/setting.xml中的<mirrors>标签，为其添加如下子标签：

4. 配置环境变量：MAVEN_HOME为maven的解压目录，并将其bin目录加入PATH环境变量

5. 命令行中测试 

   ```shell
   mvn -v
   ```



IDEA创建Maven项目

![image-20241030184929162](Spring.assets/image-20241030184929162.png)

Maven中的坐标是<font color=red>资源的唯一标识，通过该坐标可以唯一定位资源的位置</font>

使用坐标来定义项目或引入项目中需要的依赖

![image-20241030185707674](Spring.assets/image-20241030185707674.png)

- groupId：定义当前Maven项目隶属组织名称
- artifactId：定义当前Maven项目名称（通常是模块名称）
- version：定义当前项目版本号

依赖配置：

![image-20241030191533568](Spring.assets/image-20241030191533568.png)

没有的话，可以直接去官方Maven去搜复制maven代码即可。

![image-20241030191643080](Spring.assets/image-20241030191643080.png)



