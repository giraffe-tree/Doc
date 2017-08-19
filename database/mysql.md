# MYSQL 使用

#### 工具： mysql 5.5.16  workbench 6.3 powershell

### 基本操作

- 查看表信息、结构

> DESCRIBE actor;

- 注释
> -- 或者 #


查询
	limit
		select actor_id,first_name from actor limit 3，4;
			limit 第一个数为开始位置，第二个数为要检索的行数。
		同：select actor_id,first_name from actor  limit 4 offset 3;
			offset 偏移，偏移最前面的三个数，即舍去最前面的三个数
	order
		select *  order by first_name,last_name;
			仅在多个行具有相同的first_name时才对它按last_name进行排序
		select * from actor order by first_name DESC,last_name ASC;
			在前一列的基础上进行升降序
		关于大小写的字母排序
			在字典排序顺序中，A被视为与a相同，这是MySQL（和大多数数据库管理系统）的行为
			所以当查询多个仅大小写不同的字段时，用desc、asc排序之后的结果可能一致
	where
		select *  order where first_name  = "ALEC" ;
			将会把alec、Alec、aLEC都查询出来，不管是utf-8 bin 还是utf-8 general ci
		select * from actor where actor_id between 10 and 20;
			使用between 包括 10,20
			同理，当使用：
				select * from actor where  actor_id not  between 10 and 20;
			不包括actor_id=10,20的情况
		select * from actor where score  = 2*score_double;
			score 为int，score_double 为double 类型
			不会四舍五入，仅当score_double 小数点后全为0才能相等
		select * FROM actor where last_name  is null;
			select * FROM actor where last_name  is  not null;
			null值检测

	or and
		组合过滤 where 后使用多个限定语句 连接使用 or and
		select * FROM actor where last_name  is not null and actor_id >200 and score >0;
		select * FROM actor where actor_id < 10 or score =20;

		select * FROM actor where (actor_id > 0 or actor_id = 20) and  score =20 ;
			当有多个and、or时，mysql会先处理and，and的优先级更高，要改变运算顺序应当使用 圆括号
		select * from actor where actor_id in(1,8,10) and score in (10);
			使用in操作符来指定条件范围，取值之间使用逗号分隔，并括在圆括号内
			相比于or，使用in操作符更加清楚直观
		select * FROM actor where   actor_id > 10 or not  score =10;
		select * from actor where actor_id not  in(1,8,10) and score in (10);
			这二句 not 不能作用于score in (10);
			也就是说这里的not只能否定一个子句，作用范围在where/and/or 之间
		select * from actor where not actor_id between 10 and 20;
		select * from actor where  actor_id not  between 10 and 20;
			not 可以作用在between上，not 放在哪个位置并不受影响
			select * from actor where not actor_id   between 10 and 200 and score_double != 10;
				查询出：在0-9之间的score_double不等于10的项

通配符 wildcard
	LIKE ，指示MySQL后跟的搜索模式利用通配符匹配而不是直接相等匹配进行比较
		select * FROM actor where binary first_name   like '%al%';
		mysql 默认不区分大小写
			但当加入binary（中文是二进制的意思）后，mysql 就会区分大小写
			select * FROM actor where  first_name like  'a%ec';
			重要的是要注意到，除了一个或多个字符外，%还能匹配0个字符。%代表搜索模式中给定位置的0个、1个或多个字符
		select * FROM actor where  last_name like  '%' ;
			除了NULL都可以匹配
		尾空格可能会干扰通配符匹配
			使用trim , LTrim, RTrim
			select * FROM actor where  trim(first_name) like  'alec%' ;
	下划线 _
		只匹配单个字符而不是多个字符,且总是匹配一个字符，不能多也不能少，不能为0个字符
		select * FROM actor where  first_name like  'a_ec' ;

正则表达式
	like 和 regexp 的区别
		Like匹配整个字段，而正则表达式regexp在列值内进行部分匹配
		即LIKE匹配整个串而REGEXP匹配子串
		select * FROM actor where  first_name  regexp 'alec';
		相当于
		select * FROM actor where  first_name  like '%alec%';
		两者都不区分大小写
	.的作用
		select * FROM actor where  first_name  regexp '.alec';
		相当于 %alec 且alec左边必须有字符
		匹配除了null的字符
	或 |
		select * FROM actor where  actor_id  regexp '1|2';
			只要actor_id 中包含1或者2，包括11,12。。。。91,92。。。。
		但是 select * FROM actor where  actor_id  in (1,2);
			只能匹配两个项，即actor_id=1,2两项
	[]
		select * FROM actor where  first_name  regexp '[ab]lec';
			'[ab]lec' 即 '[a|b]lec'
		匹配alec 或者 blec ，且是进行的部分匹配，相当于 %alec%  and %blec%
		使用[0-9]、[a-z]定义了一个范围
			select * FROM actor where  first_name  regexp '[a-d]lec';
			多个范围叠加
				select * FROM actor where  first_name  regexp '[0-9A-Za-z]lec';
			{数字}  限定数目，默认为1
				select * FROM actor where  first_name  regexp '[0-9A-Za-z]{2}lec';
				'lec'前[0-9A-Za-z]中的个数必须大于等于2
			是根据ascii码表的顺序来的
			48 0   57  9
			65 A   90  Z
			97 a   122 z  123/5 {}   126  ~ 127 del

	匹配特殊字符
			为了匹配特殊字符，必须用\\为前导。\\-表示查找-，\\.表示查找.
			\\\ 不能匹配\ ？
		[:alnum:] 任意字母和数字（同[a-zA-Z0-9]）
		[:alpha:] 任意字符（同[a-zA-Z]）
		[:blank:] 空格和制表（同[\\t]）
		[:cntrl:] ASCII控制字符（ASCII 0到31和127）
		[:digit:] 任意数字（同[0-9]）
		[:graph:] 与[:print:]相同，但不包括空格
		[:lower:] 任意小写字母（同[a-z]）
		[:print:] 任意可打印字符 ,空格也算
		[:punct:] 既不在[:alnum:]又不在[:cntrl:]中的任意字符
		[:space:] 包括空格在内的任意空白字符（同[\\f\\n\\r\\t\\v]）
		[:upper:] 任意大写字母（同[A-Z]）
		[:xdigit:] 任意十六进制数字（同[a-fA-F0-9]）

		具体使用：
			select * FROM sakila.actor where  score  regexp '[[:digit:]]{2}';
			select * FROM sakila.actor where  first_name  regexp '[[:alnum:]]{6}';
			select * FROM sakila.actor where  last_name  regexp '[[:punct:]]{1}';
				匹配 连续的数字、字母、非控制且非字母数字
		? 的使用
			SELECT * from sakila.actor where first_name regexp '\\([0-9] abcd?e';
				匹配abcde/adce，正则表达式中的括号要转义为 \\(
			SELECT * from sakila.actor where first_name regexp '\\([0-9] abcd?';
				即abc 后可以匹配任意值
		+ 的使用
			SELECT * from sakila.actor where first_name regexp '\\([0-9] abc+';
				abc后匹配任意值，可以仅有abc
				相当于 '\\([0-9] abc.' 再加上 abc后没有东西的项
		定位符
			SELECT * from sakila.actor where first_name regexp '^C';
				查找以C开头的项
			SELECT * from sakila.actor where first_name regexp '^[a-c\\.]';
				查找以a/b/c/. 开头的项
			SELECT * from sakila.actor where first_name regexp 'b[a-c\\.]$';
				查找以ba/bb/bc/b. 结尾的项
		查找单词
			SELECT * from sakila.actor where first_name  REGEXP '[[:<:]]ed[[:>:]]';
				找到单词 ed


处理字段
	函数
		concat 拼接字符串
	别名
		SELECT actor_id,first_name as actor_name from sakila.actor ;
	日期处理
		timestamp 转为 date 查询
			select * from actor where date(last_update) = '2017-08-08';
		查找一定时间内的数据
			select * from actor where last_update between '2017-08-08 11:00:00' and now();
			select * from actor where year(last_update) = 2017 and month(last_update) = 8;
	类型转换
		类型
			二进制,同带binary前缀的效果 : BINARY
  			字符型,可带参数 : CHAR()
 			日期 : DATE
  			时间: TIME
 			日期时间型 : DATETIME
 			浮点数 : DECIMAL
  			整数 : SIGNED
  			无符号整数 : UNSIGNED
  		函数
  			CAST(value as type)
  				select cast(19.5 as signed);#自动四舍五入到20
  				select cast(-19.5 as signed);#-20 不是-19
  			CONVERT(value, type)
  				select convert(-19.5,signed);#-20 不是-19


	处理小数
		select cast(19.16558 as decimal(9,2));#精确到几位
			select cast(19.5 as unsigned);#自动四舍五入到20
		select round(123.5); #正四舍五入，负即正的四舍五入取负
			select round(19.5);#20
			select round(-19.5);#-20
		select floor(100*rand());#取整数部分
		select ceil(123.5);#真正的四舍五入
			select ceil(19.5);#20
			select ceil(-19.5);#-19

	聚集函数
		AVG() 返回某列的平均值
			distinct 只取不同值
			select count(distinct score) from actor;
			找出不同score的个数
		COUNT() 返回某列的行数
		MAX() 返回某列的最大值
		MIN() 返回某列的最小值
		SUM() 返回某列值之和

分组数据
	select score ,count(*) as num from actor group by score;
	with rollup
		select score ,count(*) as num from actor group by score with rollup;
		会对分组进行数量汇总
	group by 多个组
		select  date(payment_date) as pdate,count(*)as amount,staff_id from payment
			group by  date(payment_date) ,staff_id;
	过滤分组
	having
		目前为止所学过的所有类型的WHERE子句都可以用HAVING来替代。
		唯一的差别是WHERE过滤行，而HAVING过滤分组。
		HAVING支持所有WHERE操作符
		WHERE在数据分组前进行过滤，HAVING在数据分组后进行过滤
			select score ,count(*) as num from actor where actor_id >20 group by score
				having score > 4 ;
			select  date(payment_date) as pdate,count(*)as amount ,staff_id from payment
				group by  date(payment_date)  ,staff_id having amount >50;
	select 子句顺序
	 	select from where group by having order by limit


子查询 subquery
	select first_name from actor where actor_id in (select actor_id from film_actor );

联结 join
	两张没有联结关系的表select后返回笛卡尔积
	内连接
		select * from A inner join B on A.name = B.name;
	自联结
	使用连接查询，而不是子查询
	 	select address, city.city as cityName,country.country as countryName
	 	from address, city,country
		where address.city_id = city.city_id and city.country_id = country.country_id;
	二义性的子查询/连接————取别名
		select * from address as a1,address as a2
			where a1.last_update = a2.last_update and a2.address_id = 11;
			查询与id=11的项有相同更新时间的项
			不需要复杂的子查询
		select address,city.country_id from address left outer join city on
			address.city_id = city.city_id;


组合查询(union并) commpound query 复合查询
	什么时候使用
		在单个查询中从不同的表返回类似结构的数据；
		对单个表执行多个查询，按单个查询返回数据。
	union 默认会自动去除重复的行
		但也可以返回所有匹配的行，变成 union all 就可以了
		select * from actor where actor_id <10
		union all
		select * from actor where score = 10;
	在用UNION组合查询时，只能使用一条ORDER BY子句，它必须出现在最后一条SELECT语句之后

全文本搜索
	MyISAM支持全文本搜索，但不支持事务处理；
	而InnoDB支持事务处理，但不支持全文本搜索

数据插入insert
	insert low_priority into
		降低插入优先级
	插入查询出来的数据
		insert into address(address,address2,district,city_id,postal_code,phone,last_update)
		select address,address2,district,city_id,postal_code,phone,last_update
 		from address where city_id =349;
更新和删除数据
	更新一条数据
		update address set city_id =111 where address_id= 606;
	在更新中使用子查询
		update address set city_id =503 where city_id in
			(select city_id from city where city_id  = 111) and address_id>0;
		当不使用主键进行更新时，会产生安全错误

