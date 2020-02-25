IF���� ����� �� �ֳ���?

DECODE(A,B,'T','F')

SELECT decode(1,1,'T','F') FROM dual

�츮ȸ�翡 �ٹ��ϴ� ����߿��� job salesman�� ��
clerk�� ��, �������� ��Ÿ�� ������ ����ϴ� sql���� �ۼ��Ͻÿ�


SELECT sum(decode(job,'CLERK',sal,null)) as "clerk"
      ,sum(decode(job,'SALESMAN',sal,null)) as "salesman"
      ,sum(decode(job,'CLERK',null,decode(job,'SALESMAN',null,sal))) as "etc"
      ,sum(decode(job,null,null,sal)) 
      - (sum(decode(job,'CLERK',sal,null))
      +sum(decode(job,'SALESMAN',sal,null))) as "etc"
      ,sum(decode(job,'CLERK',null,'SALESMAN',null,sal))
    FROM emp



����1:�ִ� ���ǽð��� ������ ������ '�Ϲݰ���'�� ��ȯ�ϰ�
�������� '��Ÿ����'�̶�� ����ϴ� sql���� �ۼ��Ͻÿ�

����2: �ִ� ���ǽð��� ������ ���� ������ ���ڸ� �˰� �ʹ�.
�����?
--�ݵ�� decode�� Ǯ�����

����3:lec_time�� ũ�� '�������',lec_point�� ũ�� '��Ÿ����' ���� ������'�Ϲ�'�� ����ϴ� select���� �ۼ��� ���ÿ�

SELECT *
    FROM LECTURE;
    
SELECT lec_id,decode(lec_time,lec_point,'�Ϲݰ���','��Ÿ����')
    FROM lecture;

SELECT count(decode(lec_time,lec_point,'��',null))
    FROM lecture;

SELECT 
    count(*)
    FROM lecture
    WHERE lec_time=lec_point;

decode�� ũ�� ������ ���Ҽ� �����Ƿ� sign���

SELECT sign(500-20),sign(20-500),sign(50-50)
FROM dual   
 
SELECT  lec_id,lec_time,lec_point, decode(sign(lec_time-lec_point),1,'�������'
                                                            ,-1,'��Ÿ����'
                                                             ,0,'�Ϲ�')
    FROM lectureT_LETITBE 
    
�������� 
�����Ͽ� �ش����ڿ� 01�� �ٿ��� 4�ڸ� ��ȣ�� �����,
ȭ���Ͽ� 11,�����Ͽ� 21, ����Ͽ� 31, �ݿ��Ͽ� 41,
����Ͽ� 51, �Ͽ��Ͽ� 61�� �ٿ��� 4�ڸ� ��ȣ�� ����ٰ� �����ҋ�
������ ��ȣ�� ����ϴ� sql�� �ۼ��Ͻÿ�.

SELECT CONCAT(to_char(sysdate,'dd'),
       decode(to_char(sysdate,'day'),'������',01
                                  ,'ȭ����',11
                                  ,'������',21
                                  ,'�����',31
                                  ,'�ݿ���',41
                                  ,'�����',51
                                  ,'�Ͽ���',61)) as "���þ�ȣ"
 from dual;
 
SELECT to_char(sysdate,'dd')||decode(to_char(sysdate,'day') ,'������',01
                                                        ,'ȭ����',11
                                                        ,'������',21
                                                        ,'�����',31
                                                        ,'�ݿ���',41
                                                        ,'�����',51
                                                        ,'�Ͽ���',61) as "���þ�ȣ"
from dual;

SELECT decode(to_char(sysdate,'day') ,'������',to_char(sysdate,'dd')||01
                                  ,'ȭ����',to_char(sysdate,'dd')||11
                                  ,'������',to_char(sysdate,'dd')||21
                                  ,'�����',to_char(sysdate,'dd')||31
                                  ,'�ݿ���',to_char(sysdate,'dd')||41
                                  ,'�����',to_char(sysdate,'dd')||51
                                  ,'�Ͽ���',to_char(sysdate,'dd')||61) as "���þ�ȣ"
from dual;