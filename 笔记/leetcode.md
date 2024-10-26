



![image-20241017161050650](C:\Users\SZA\AppData\Roaming\Typora\typora-user-images\image-20241017161050650.png)

![image-20241017161121921](C:\Users\SZA\AppData\Roaming\Typora\typora-user-images\image-20241017161121921.png)





###  Java HashMap

#### <font color=blue>Java HashMap put() 方法</font>

put()方法将指定的键值对插入到HashMap中。若插入的key对应的value已经存在，则执行value替换操作，返回旧的value值，如果不存在则执行插入，返回null

语法为：

```java
hashmap.put（K key，V value）
```

Demo：

```java
	HashMap<Character, Integer> dic = new HashMap<>();
	System.out.println( dic.put('a', 0) ); // null
	System.out.println( dic.put('a', 1) ); // 1
	System.out.println(dic); // {a=1}
```

#### <font color=blue>Java HashMap getOrDefault() 方法</font>

getOrDefault()方法获取指定key对应value，如果找不到key，则返回设置的默认值。

语法为：

```java
hashmap.getOrDefault(Object key, V defaultValue)
```

Demo：

```java
HashMap<Character, Integer> dic = new HashMap<>();
		// 字符串的字符频率统计
		String str = "abcdefabc";
		
		for (int i = 0;i<str.length();i++) {
			dic.put(str.charAt(i), dic.getOrDefault(str.charAt(i), 0)+1);
		}
		
		System.out.println(dic); //  {a=2, b=2, c=2, d=1, e=1, f=1}
```

#### <font color=blue>Java HashMap containsValue() 方法</font>

containsValue() 方法检查 hashMap 中是否存在指定的 value 对应的映射关系。

语法：

```java
public boolean containsValue(Object value)
```

Demo：

```java
		// 创建一个 HashMap
        HashMap<Integer, String> sites = new HashMap<>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        System.out.println("sites HashMap: " + sites);

        //检查映射中值value是否有Java
        if(sites.containsValue("Runoob")) {
            System.out.println("Runoob 存在于 sites 中");
        }
```

#### <font color=blue>Java HashMap containsKey() 方法</font>

containsKey() 方法检查 hashMap 中是否存在指定的 key 对应的映射关系。

语法：

```java
public boolean containsKey(Object key)
```

Demo：

```java
		// 创建一个 HashMap
        HashMap<Integer, String> sites = new HashMap<>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        System.out.println("sites HashMap: " + sites);

        //检查 key 为 1 是否存在
        if(sites.containsKey(1)) {
            System.out.println("key 为 1 存在于 sites 中");
        }
```



#### <font color=blue>Java HashMap values() 方法 </font>

values() 方法返回映射中所有 value 组成的 Set 视图。

语法：

```java
public Collection<V> values()
```

Demo：

```java
		HashMap<Character, Integer> dic = new HashMap<>();
		// 字符串的字符频率统计
		String str = "abcdefabc";
		
		for (int i = 0;i<str.length();i++) {
			dic.put(str.charAt(i), dic.getOrDefault(str.charAt(i), 0)+1);
		}
		
		Collection<Integer> values = dic.values();
		System.out.println(values);
		for (Integer value:values) {
			System.out.print(value);
		}
```
## <font color=red>**Java HashSet**</font>

HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。
HashSet 允许有 null 值。
HashSet 是无序的，即不会记录插入的顺序。
HashSet 不是线程安全的， 如果多个线程尝试同时修改 HashSet，则最终结果是不确定的。 您必须在多线程访问时显式同步对 HashSet 的并发访问。
HashSet 实现了 Set 接口。

#### <font color=blue>Java HashSet add() 方法</font>

添加元素：

```java
    HashSet<Integer> set1 = new HashSet<Integer>();
    	
    set1.add(1);
    set1.add(1);
    System.out.println(set1); // [1]
```

#### <font color=blue>Java HashSet contains() 方法</font>

如果此set包含指定的元素，则返回`true` 。 更正式地说，返回`true`当且仅当此set包含的元素`e` ，使得`Objects.equals(o, e)` 。

语法：

```java
public boolean contains(Object o)
```

Demo：

```java
    HashSet<String> sites = new HashSet<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");  // 重复的元素不会被添加
        System.out.println(sites.contains("Taobao")); // true
    }
```

#### <font color=blue>Java HashSet size() 方法</font>
返回此集合中的元素数（基数）。
语法：

```java
public int size()
```





## <font color=red><u>Java String</u></font> 

**length——数组的属性；**

**length()——String的方法；**

**size()——集合的方法；**

#### <font color=blue>Java charAt() 方法</font>

charAt()方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。

语法：

```java
public char charAt(int index)
```

Demo:

```java
	String s = "www.baidu.com";
	char result = s.charAt(6);
    System.out.println(result);// i 
```

#### <font color=blue>Java String 遍历方法</font>

使用toCharArray()，增强for：

```java
    	String str = "1243523";
    	for (char c:str.toCharArray()) {
    		System.out.println(c);
    	}
```

使用charAt()，普通for循环：

```java
    	String str = "1243523";
    	for (int i=0; i<str.length() ; i++) {
    		System.out.println(str.charAt(i));
    	}
```

### <font color=red>**<u>Java ArrayList</u>**</font>

ArrayList 和 Vector 都实现了List接口，List接口继承了Collection接口，都是有序集合

区别在于Vector使用了**Synchronized** 来实现[线程同步](https://so.csdn.net/so/search?q=线程同步&spm=1001.2101.3001.7020)，是线程安全的，而 ArrayList 是非线程安全的。

```java
import java.util.ArrayList; // 引入 ArrayList 类

// E:泛型数据类型，用于设置objectName的数据类型，只能为引用类型
ArrayList<E> objectName =new ArrayList<>();　 // 初始化
// 错误ArrayList<char> ==> 正确ArrayList<Character>
```

#### <font color=blue>ArrayList 添加元素add</font>

```java
ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites);
```

#### <font color=blue>ArrayList 访问元素get()</font>

```java
ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites.get(1));  // 访问第二个元素
```

#### <font color=blue>ArrayList 修改元素set(int index, E element)</font>

```java
ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        sites.set(2, "Wiki"); // 第一个参数为索引位置，第二个为要修改的值
        System.out.println(sites);
```

#### <font color=blue>ArrayList 删除元素remove()</font>

```java
ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        sites.remove(3); // 删除第四个元素
        System.out.println(sites);
```

#### <font color=blue>ArrayList 计算大小size()</font> Collection都是size()

```java
ArrayList<String> sites = new ArrayList<String>();
System.out.println(sites.size());
```

## <u>Java Arrays：专为数组而生的工具类</u>

#### <font color=blue>Arrays 创建数组</font>

1.  copyOf：复制指定的数组，截取或用 null 填充

   ```java
   String[] intro = new String[] { "沉", "默", "王", "二" };
   String[] revised = Arrays.copyOf(intro, 3);
   String[] expanded = Arrays.copyOf(intro, 5);
   System.out.println(Arrays.toString(revised));
   System.out.println(Arrays.toString(expanded));
   ```

2. copyOfRange，复制指定范围内的数组到一个新的数组：

   ```java
   String[] intro = new String[] { "沉", "默", "王", "二" };
   String[] abridgement = Arrays.copyOfRange(intro, 0, 3);
   System.out.println(Arrays.toString(abridgement));
   ```

3. fill，对数组进行填充：

   ```java
   String[] stutter = new String[4];
   Arrays.fill(stutter, "沉默王二");
   System.out.println(Arrays.toString(stutter)); 
   // [沉默王二, 沉默王二, 沉默王二, 沉默王二] 如果想要一个元素完全相同的数组时 fill() 方法就派上用场了
   ```

#### <font color=blue>Arrays 比较数组</font>

Arrays 类的 `equals()` 方法用来判断两个数组是否相等：

```java
String[] intro = new String[] { "沉", "默", "王", "二" };
boolean result = Arrays.equals(new String[] { "沉", "默", "王", "二" }, intro);
System.out.println(result);
boolean result1 = Arrays.equals(new String[] { "沉", "默", "王", "三" }, intro);
System.out.println(result1);
```

#### <font color=blue>Arrays 数组排序</font>

Arrays 类的 `sort()` 方法用来对数组进行排序：

```java
String[] intro1 = new String[] { "chen", "mo", "wang", "er" };
String[] sorted = Arrays.copyOf(intro1, 4);
Arrays.sort(sorted);
System.out.println(Arrays.toString(sorted));
```

#### <font color=blue>Arrays 数组检索</font>

数组排序后就可以使用 Arrays 类的 `binarySearch()` 方法进行二分查找了。否则的话，只能线性检索，效率就会低很多。

```java
String[] intro1 = new String[] { "chen", "mo", "wang", "er" };
String[] sorted = Arrays.copyOf(intro1, 4);
Arrays.sort(sorted);
int exact = Arrays.binarySearch(sorted, "wang");
System.out.println(exact);
int caseInsensitive = Arrays.binarySearch(sorted, "Wang", String::compareToIgnoreCase);
System.out.println(caseInsensitive);
```

#### <font color=blue>Arrays 数组打印</font>

```java
Arrays.toString()
```

#### <font color=blue>Arrays 数组转 List</font>

尽管数组非常强大，但它自身可以操作的工具方法很少，比如说判断数组中是否包含某个值。如果能转成 List 的话，就简便多了，因为 Java 的[集合框架 List](https://javabetter.cn/collection/gailan.html) 中封装了很多常用的方法。

```java
String[] intro = new String[] { "沉", "默", "王", "二" };
List<String> rets = Arrays.asList(intro);
System.out.println(rets.contains("二"));
```

不过需要注意的是，`Arrays.asList()` 返回的是 `java.util.Arrays.ArrayList`，并不是` java.util.ArrayList`，它的长度是固定的，无法进行元素的删除或者添加。

要想操作元素的话，需要多一步转化，转成真正的 `java.util.ArrayList`：

```java
List<String> rets1 = new ArrayList<>(Arrays.asList(intro));
rets1.add("三");
rets1.remove("二");
```

