
SELECT * FROM temp;

SELECT emp_name as "��� ��"
        ,(salary/18) as "Ȧ���޿�"
        ,(salary/18)*2 as "¦���޿�"
FROM temp

SELECT round(123.567,2),round(123.345,2)
        ,round(123.340,0),round(123.345,-1)
    FROM dual

SELECT emp_name as "��� ��"
        ,round((salary/18),-1)||'��' as "Ȧ���޿�"
        ,round((salary/18)*2,-1)||'��' as "¦���޿�"
FROM temp
-- round(����,�ڸ�) �ش� �ڸ����� �ݿø� -1 �����ڸ�

SELECT 1||'��','$'||100 FROM dual

SELECT to_char(123456789,'999,999,999') FROM dual -- 9�¼����� �ڸ����� ũ�� ���������

SELECT emp_name as "��� ��"
        ,to_char(round((salary/18)),'999,999,999')||'��' as "Ȧ���޿�"
        ,to_char(round((salary/18)*2),'999,999,999')||'��' as "¦���޿�"
FROM temp

--Temp�ڷ��� hobby�� ����� ����� �̸��� ��̸� ����ϴ�
--sql�� �ۼ��Ͻÿ�.

SELECT emp_name as "����̸�",hobby as "���"
    FROM temp
    WHERE hobby in('���','����');
    
/*����Ŭ������ �����Ǵ� �Լ��� �ִ�.
�Լ��� �̸��ڿ� ��ȣ�� �ִ�.
�Լ��� �ݵ�� ��ȯ���� �ִ�.
*/

SELECT round(123.567,1) FROM dual

round(��,�ڸ���) �ι�° �ڸ����� �ݿø�

�׷��Լ��� �����ȴ�.

SELECT sum(salary),to_char(sum(salary),'999,999,999')
       ,sum(salary/12),to_char(sum(salary/12),'999,999,999')
        from temp;

SELECT birth_date
FROM temp
WHERE  birth_date LIKE '%'||'15'||'%'

SELECT count(*)
from temp;

SELECT address as "�ּ�", zipcode as "�����ȣ"
FROM zipcode_t
WHERE dong LIKE '%'||'��굿'||'%'