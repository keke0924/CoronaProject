import pandas as pd
import requests
from bs4 import BeautifulSoup
import pymysql
from selenium import webdriver

chromedriver ='C:\cromedriver\chromedriver.exe'

driver = webdriver.Chrome(chromedriver)
driver.get('http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=')
driver.implicitly_wait(15)



table = driver.find_element_by_class_name('num.midsize')
#tbody = table.find_element_by_tag_name("tbody")
#rows = tbody.find_elements_by_tag_name("tr")
contents = table.find_elements_by_tag_name("tbody > tr > td")
"""
for index, value in enumerate(rows):
    body=value.find_elements_by_tag_name("td")[0]
    body2 = value.find_elements_by_tag_name("td")[3]
    print(body.text)
    print(body2.text)
"""
allobs=[]
for content in contents:
    allobs.append(content.text.strip())
d = pd.DataFrame(columns = allobs)
#print(d)
seoultoday = print(allobs[8])
busantoday = print(allobs[16])
degutoday = print(allobs[24])
incheontoday = print(allobs[32])
gyeongjutoday = print(allobs[40])
daejeontoday = print(allobs[48])
ulsantoday = print(allobs[56])
sejongtoday = print(allobs[64])
gyeonggitoday = print(allobs[72])
gangwontoday = print(allobs[80])
chungbuktoday = print(allobs[88])
chungnamtoday = print(allobs[96])
jeonbuktoday = print(allobs[104])
jeonnamtoday = print(allobs[112])
gyeongbuktoday = print(allobs[120])
gyeonnamtoday = print(allobs[128])
jeajutoday = print(allobs[136])
xtoday = print(allobs[144])

seoultotal = print(allobs[11])
busan = print(allobs[19])
degu = print(allobs[27])
incheon = print(allobs[35])
gyeongju = print(allobs[43])
daejeon = print(allobs[51])
ulsan = print(allobs[59])
sejong = print(allobs[67])
gyeonggi = print(allobs[75])
gangwon = print(allobs[83])
chungbuk = print(allobs[91])
chungnam = print(allobs[99])
jeonbuk = print(allobs[107])
jeonnam = print(allobs[115])
gyeongbuk = print(allobs[123])
gyeonnam = print(allobs[131])
jeaju = print(allobs[139])
x = print(allobs[147])

