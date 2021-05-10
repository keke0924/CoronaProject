import pandas as pd
import requests
from bs4 import BeautifulSoup
import pymysql





req = requests.get('http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=')
html=req.text
soup=BeautifulSoup(html,'html.parser')

contents = soup.select('table > tbody > tr > td')
allobs=[]
for content in contents:
    allobs.append(content.text.strip())
d = pd.DataFrame(columns = allobs)

seoultoday = (allobs[8])
busantoday = (allobs[16])
degutoday = (allobs[24])
incheontoday = (allobs[33])
gyeongjutoday = (allobs[41])
daejeontoday = (allobs[48])
ulsantoday = (allobs[56])
sejongtoday = (allobs[64])
gyeonggitoday = (allobs[72])
gangwontoday = (allobs[80])
chungbuktoday = (allobs[88])
chungnamtoday = (allobs[96])
jeonbuktoday = (allobs[104])
jeonnamtoday = (allobs[112])
gyeongbuktoday = (allobs[120])
gyeonnamtoday = (allobs[128])
jeajutoday = (allobs[136])
xtoday = (allobs[144])
#print("total")
#total = print(allobs[:8])
seoultotal = (allobs[11])
busan = (allobs[19])
degu = (allobs[27])
incheon = (allobs[35])
gyeongju = (allobs[43])
daejeon = (allobs[51])
ulsan = (allobs[59])
sejong = (allobs[67])
gyeonggi = (allobs[75])
gangwon = (allobs[83])
chungbuk = (allobs[91])
chungnam = (allobs[99])
jeonbuk = (allobs[107])
jeonnam = (allobs[115])
gyeongbuk = (allobs[123])
gyeonnam = (allobs[131])
jeaju = (allobs[139])
x = (allobs[147])

mydb = pymysql.connect(
    host='localhost', user='root', password='yujin2019!', db='dbtest', charset='utf8'

)

mycursor = mydb.cursor()
#mycursor.execute("CREATE TABLE present(local VARCHAR(20) PRIMARY KEY, today VARCHAR(1000), total VARCHAR(10000))")

sql = "REPLACE INTO present (local, today, total) VALUES (%s, %s, %s)"
val = [
     ("서울", seoultoday, seoultotal),
     ("부산", busantoday, busan),
     ("대구", degutoday, degu),
     ("인천", incheontoday, incheon),
     ("광주", gyeongjutoday, gyeongju),
     ("대전", daejeontoday, daejeon),
     ("울산", ulsantoday, ulsan),
     ("세종", sejongtoday, sejong),
     ("경기", gyeonggitoday, gyeonggi),
     ("강원", gangwontoday, gangwon),
     ("충북", chungbuktoday, chungbuk),
     ("충남", chungnamtoday, chungnam),
     ("전북", jeonbuktoday, jeonbuk),
     ("전남", jeonnamtoday, jeonnam),
     ("경북", gyeongbuktoday, gyeongbuk),
     ("경남", gyeonnamtoday, gyeonnam),
     ("제주", jeajutoday, jeaju),
     ("검역", xtoday, x)
    ]

mycursor.executemany(sql, val)
mydb.commit()
mydb.close()
