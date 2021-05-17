import pandas as pd
import requests
from bs4 import BeautifulSoup
import pymysql
from selenium import webdriver

chromedriver ='C:\cromedriver\chromedriver.exe'

driver = webdriver.Chrome(chromedriver)
driver.get('https://www.seoul.go.kr/coronaV/coronaStatus.do')
driver.implicitly_wait(15)



table = driver.find_element_by_class_name('tstyle-status.pc.pc-table')
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

강남구총확진자 = (allobs[0])
강동구총확진자 = (allobs[1])
강북구총확진자 = (allobs[2])
강서구총확진자 = (allobs[3])
관악구총확진자 = (allobs[4])
광진구총확진자 = (allobs[5])
구로구총확진자 = (allobs[6])
금천구총확진자 = (allobs[7])
노원구총확진자 = (allobs[8])
도봉구총확진자 = (allobs[9])
동대문구총확진자 = (allobs[10])
동작구총확진자 = (allobs[11])
마포구총확진자 = (allobs[12])
서대문구총확진자 = (allobs[26])
서초구총확진자 = (allobs[27])
성동구총확진자 = (allobs[28])
성북구총확진자 = (allobs[29])
송파구총확진자 = (allobs[30])
양천구총확진자 = (allobs[31])
영등포구총확진자 = (allobs[32])
용산구총확진자 = (allobs[33])
은평구총확진자 = (allobs[34])
종로구총확진자 = (allobs[35])
중구총확진자 = (allobs[36])
중량구총확진자 = (allobs[37])
기타총확진자 = (allobs[38])

강남구오늘확진자 = (allobs[13])
강동구오늘확진자 = (allobs[14])
강북구오늘확진자 = (allobs[15])
강서구오늘확진자 = (allobs[16])
관악구오늘확진자 = (allobs[17])
광진구오늘확진자 = (allobs[18])
구로구오늘확진자 = (allobs[19])
금천구오늘확진자 = (allobs[20])
노원구오늘확진자 = (allobs[21])
도봉구오늘확진자 = (allobs[22])
동대문구오늘확진자 = (allobs[23])
동작구오늘확진자 = (allobs[24])
마포구오늘확진자 = (allobs[25])
서대문구오늘확진자 = (allobs[39])
서초구오늘확진자 = (allobs[40])
성동구오늘확진자 = (allobs[41])
성북구오늘확진자 = (allobs[42])
송파구오늘확진자 = (allobs[43])
양천구오늘확진자 = (allobs[44])
영등포구오늘확진자 = (allobs[45])
용산구오늘확진자 = (allobs[46])
은평구오늘확진자 = (allobs[47])
종로구오늘확진자 = (allobs[48])
중구오늘확진자 = (allobs[49])
중량구오늘확진자 = (allobs[50])
기타오늘확진자 = (allobs[51])

mydb = pymysql.connect(
    host='localhost', user='root', password='yujin2019!', db='seoul', charset='utf8'

)

mycursor = mydb.cursor()
#mycursor.execute("CREATE TABLE seoul(local VARCHAR(20) PRIMARY KEY, today VARCHAR(1000), total VARCHAR(10000))")
sql = "REPLACE INTO seoul (local, today, total) VALUES (%s, %s, %s)"
val = [
     ("강남", 강남구오늘확진자, 강남구총확진자),
     ("강동", 강동구오늘확진자, 강동구총확진자),
     ("강북", 강북구오늘확진자, 강북구총확진자),
     ("강서", 강서구오늘확진자, 강서구총확진자),
     ("관악", 관악구오늘확진자, 관악구총확진자),
     ("광진", 광진구오늘확진자, 광진구총확진자),
     ("구로", 구로구오늘확진자, 구로구총확진자),
     ("금천", 금천구오늘확진자, 금천구총확진자),
     ("노원", 노원구오늘확진자, 노원구총확진자),
     ("도봉", 도봉구오늘확진자, 도봉구총확진자),
     ("동대문", 동대문구오늘확진자, 동대문구총확진자),
     ("동작", 동작구오늘확진자, 동작구총확진자),
     ("마포", 마포구오늘확진자, 마포구총확진자),
     ("서대문", 서대문구오늘확진자, 서대문구총확진자),
     ("서초", 서초구오늘확진자, 서초구총확진자),
     ("성동", 성동구오늘확진자, 성동구총확진자),
     ("성북", 성북구오늘확진자, 성북구총확진자),
     ("송파", 송파구오늘확진자, 송파구총확진자),
     ("양천", 양천구오늘확진자, 양천구총확진자),
     ("영등포", 영등포구오늘확진자, 영등포구총확진자),
     ("용산", 용산구오늘확진자, 용산구총확진자),
     ("은평", 은평구오늘확진자, 은평구총확진자),
     ("종로", 종로구오늘확진자, 종로구총확진자),
     ("중구", 중구오늘확진자, 중구총확진자),
     ("중랑", 중량구오늘확진자, 중량구총확진자),
     ("기타", 기타오늘확진자, 기타총확진자)
    ]

mycursor.executemany(sql, val)
mydb.commit()
mydb.close()
