#### mapper无法注入问题？
Answer：给mapper类加上@Component注解

#### 注意sql语句的空格问题。

#### Mybatis 不认 表名.属性 这种形式，对于它来说表名.属性=属性，所以当有个两个表的属性名相同，在进行联合查询时，要给其中的一个表的属性起个别名，例如 SELECT a.id ,b.id as bid FROM a,b
