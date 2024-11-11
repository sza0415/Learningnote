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

# Spring

## Spring Framework系统框架

![image-20241105170720691](./Spring.assets/image-20241105170720691.png)

## IoC（Inversion of Control）控制反转

背景引入：

![image-20241105165152863](./Spring.assets/image-20241105165152863.png)

<font color=yellow>代码耦合度偏高：</font>原先在业务逻辑层的实现类（BookServiceImpl）中会new一个数据访问层的实现类（BookDaoImpl），当出现一个数据访问层迎来了一个全新的实现（BookDaoImpl2），业务逻辑层的相关代码就需要改变。

解决方案：使用对象时，在程序中不要主动使用new产生对象，转换为<font color=yellow>外部提供对象</font>，这就是IoC（Inversion of Control）控制反转 => <u>对象的创建控制权由程序转移到<font color=yellow>外部</font></u>

Spring技术对IoC思想进行了实现：

- Spring提供了一个容器，称为<font color=yellow>IoC容器
  </font>，用来充当IoC思想中的<font color=yellow>“外部”</font>
- IoC容器负责对象的创建、初始化等一系列的工作，被创建或管理的对象在IoC容器中统称为<font color=yellow>Bean</font>

业务逻辑层（service）的对象与数据访问层（dao）的对象都可以放入IoC容器当中

service层的对象的运行依赖于dao层对象

![image-20241105171824851](./Spring.assets/image-20241105171824851.png)

使用<font color=yellow>DI（Dependency Injection）依赖注入</font>进行解决：

- 依赖注入，在容器中建立bean于bean之间的依赖关系的整个过程。

步骤：

1. 使用IoC容器管理bean
2. 在IoC容器中将有依赖关系的bean进行关系绑定（DI）

最终效果：

使用对象时不仅可以直接从IoC容器中获取，并且获取到的bean已经绑定了所有的依赖关系

## IoC入门案例

#### 入门案例思路分析

1. Spring是使用容器来管理bean对象的，那么管什么?
   - 主要管理项目中所使用到的类对象，比如(Service和Dao)
2. 如何将被管理的对象告知IOC容器?
   - 使用配置文件
3. 被管理的对象交给IOC容器，要想从容器中获取对象，就先得思考如何获取到IOC容器?
   - Spring框架提供相应的接口
4. IOC容器得到后，如何从容器中获取bean?
   - 调用Spring框架提供对应接口中的方法
5. 使用Spring导入哪些坐标?
   - 用别人的东西，就需要在pom.xml添加对应的依赖



#### 入门案例代码实现

需求分析:将BookServiceImpl和BookDaoImpl交给Spring管理，并从容器中获取对应的bean对象进行方法调用。

1. 创建Maven的java项目

2. pom.xml添加Spring的依赖jar包

```xml
    <dependencies>
        
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>6.1.14</version>
        </dependency>
        
    </dependencies>

```

3. 创建BookDao，BookDaoImpl，BookService和BookServiceImpl四个类

```java
public interface BookDao {
    public void save();
}
```

```java
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ...");
    }
}
```

```java
public interface BookService {
    public void save();
}
```

```java
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
```

4. resources下添加spring配置文件，这个spring配置文件就是将被管理的类告知IoC容器

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- applicationContext.xml spring配置文件 => 将所要管理的类添加至配置文件当中   -->

    <!-- bean标签配置bean   -->
    <!-- id属性在同一个上下文中(配置文件)不能重复 标识bean    -->
    <!-- class属性给bean定义类型 得是具体的实现类 IoC通过调用该类创造对象 -->
    <bean id="bookDao" class="org.example.dao.impl.BookDaoImpl"/>

    <bean id="bookService" class="org.example.service.impl.BookServiceImpl"/>

</beans>
```

5. 获取IOC容器，从容器中获取对象进行方法调用

```java
// main.java 调用service方法
package org.sza;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sza.dao.bookDao;
import org.sza.service.bookService;

public class Main {
    public static void main(String[] args) {
//        使用Spring ClassPathXmlApplicationContext 完成IOC容器的创建
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        使用getBean(String name)方法，其name参数就是我们在bean配置的id，通过这个id来创造对象
        bookService bookService = (bookService)context.getBean("bookService");
        bookService.save();
    }
}
```

```java
// bookServiceImpl.java 调用 Dao层方法
package org.sza.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sza.dao.bookDao;
import org.sza.service.bookService;

public class bookServiceImpl implements bookService {
    private bookDao bookDao;
    @Override
    public void save() {
        System.out.println("save book service");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookDao = (bookDao) context.getBean("bookDao");
        bookDao.save();
    }
}
```

至此，Spring的IOC入门案例已经完成，但是在`BookServiceImpl`的类中依然存在`BookDaoImpl`对象的new操作（如如果你不使用IoC容器调用的话），它们之间的耦合度还是比较高，这块该如何解决，就需要用到下面的`DI(依赖注入)`来解决bean与bean之间的依赖关系。

## DI入门案例

#### 入门案例思路分析

1. 要想实现依赖注入，必须要基于IOC管理Bean
   - DI的入门案例要依赖于前面的IOC入门案例
2. Service中使用new形式创建的Dao对象是否保留？
   - 不保留，这样才能解耦合，最终要使用IOC容器中的bean对象
3. Service中需要的Dao对象如何进入到Service中？
   - 在Service中提供一个方法（例如提供一个set方法），让Spring的IOC容器可以通过该方法传入bean对象，也就达到了不是自己new，而是外部提供
4. Service与Dao之间的关系如何描述？
   - 使用配置文件

#### 入门案例代码实现

需求：基于IOC入门案例，在BookServiceImpl类中删除new对象的方式，使用Spring的DI完成Dao层的注入

1. 删除业务层中使用new的方式创建的dao对象，在业务层提供BookDao的setter方法

```java
package org.sza.service.impl;

import org.sza.dao.BookDao;
import org.sza.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    @Override
    public void save() {
        System.out.println("save book service");

    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
```

2. 在配置文件中添加依赖注入的配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="bookDao" class="org.sza.dao.impl.BookDaoImpl"/>
    <bean id="bookService" class="org.sza.service.impl.BookServiceImpl">
        <!-- 配置Service与Dao之间的关系 -->
        <property name="bookDao" ref="bookDao"/>
    </bean>
</beans>
```

![image-20241106113808631](./Spring.assets/image-20241106113808631.png)

![image-20241111094123811](./Spring.assets/image-20241111094123811.png)

- 注意:配置中的两个bookDao的含义是不一样的，一个提供方法 一个提供对象
  - name=”bookDao”中`bookDao`的作用是让Spring的IOC容器在获取到名称后，将首字母大写，前面加set找对应的`setBookDao()`方法进行对象注入
  - ref=”bookDao”中`bookDao`的作用是让Spring能在IOC容器中找到id为`bookDao`的Bean对象给`bookService`进行注入

![img](./Spring.assets/7468686c6f2633337875727b656979326b6f322d2e2a32727968332e2c2e2e332d2c2d2c337f7a7f2b7e2a252e762c2c6e76752b2b762c2c2e72782c2c2d2a6c2c2c7a2c6c32766c7b-0873624.jpg)
