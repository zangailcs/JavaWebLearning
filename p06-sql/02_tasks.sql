-- 1. 查询价格低于 10元 的菜品的名称 、价格 及其 菜品的分类名称 .
select dish.name, dish.price, category.name
from dish
         join category on dish.category_id = category.id
where dish.price < 10;

-- 2. 查询所有价格在 10元(含)到50元(含)之间 且 状态为'起售'的菜品名称、价格 及其 菜品的分类名称 (即使菜品没有分类 , 也需要将菜品查询出来).
select dish.name, dish.price, category.name
from dish
         left join category on dish.category_id = category.id
where dish.price between 10 and 50
  and dish.status = 1;

-- 3. 查询每个分类下最贵的菜品, 展示出分类的名称、最贵的菜品的价格 .
select category.name, max(dish.price)
from dish
         join category on dish.category_id = category.id
group by category.name;

-- 4. 查询各个分类下 状态为 '起售' , 并且 该分类下菜品总数量大于等于3 的 分类名称 .
select category.name
from dish
         join category on dish.category_id = category.id
where dish.status = 1
group by category.name
having count(*) >= 3;

-- 5. 查询出 "商务套餐A" 中包含了哪些菜品 （展示出套餐名称、价格, 包含的菜品名称、价格、份数）.
select setmeal.name, dish.name, dish.price, setmeal_dish.copies
from dish,
     setmeal_dish,
     setmeal
where dish.id = setmeal_dish.dish_id
  and setmeal.id = setmeal_dish.setmeal_id
  and setmeal.name = '商务套餐A';

-- 6. 查询出低于菜品平均价格的菜品信息 (展示出菜品名称、菜品价格).
select dish.name, dish.price
from dish
where dish.price < (select avg(dish.price)
                    from dish);



