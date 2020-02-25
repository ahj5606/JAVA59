SELECT sdate,mitemp
FROM seoultemp
where sdate between '2020/01/01'
               and '2020/01/10'
               and mitemp 
               = (SELECT min(mitemp)
                    FROM seoultemp
                    WHERE sdate between '2020/01/01'
                                   and '2020/01/10');
               
               
SELECT sdate,min(mitemp)
FROM seoultemp
where sdate between '2020/01/01'
               and '2020/01/10'
group by sdate; 
               
SELECT * FROM seoultemp


commit
