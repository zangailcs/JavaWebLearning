### mysql

#### 1、查询

* null值不参与所有聚合函数运算（count时需要指定非空列）

* 统计数量可以使用：count(\*)、count(字段)、count(常量) 推荐使用count(\*)。

* where与having的区别：

  * 执行时机不同：where是分组之前进行过滤，不满足where条件不参与分组；而having是分组后对结果进行过滤
  * 判断条件不同：where不能对聚合函数进行判断，having可以

  



