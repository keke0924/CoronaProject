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

강남구총확진자 = print(allobs[0])
강동구총확진자 = print(allobs[1])
강북구총확진자 = print(allobs[2])
강서구총확진자 = print(allobs[3])
관악구총확진자 = print(allobs[4])
광진구총확진자 = print(allobs[5])
구로구총확진자 = print(allobs[6])
금천구총확진자 = print(allobs[7])
노원구총확진자 = print(allobs[8])
도봉구총확진자 = print(allobs[9])
동대문구총확진자 = print(allobs[10])
동작구총확진자 = print(allobs[11])
마포구총확진자 = print(allobs[12])
서대문구총확진자 = print(allobs[26])
서초구총확진자 = print(allobs[27])
성동구총확진자 = print(allobs[28])
성북구총확진자 = print(allobs[29])
송파구총확진자 = print(allobs[30])
양천구총확진자 = print(allobs[31])
영등포구총확진자 = print(allobs[32])
용산구총확진자 = print(allobs[33])
은평구총확진자 = print(allobs[34])
종로구총확진자 = print(allobs[35])
중구총확진자 = print(allobs[36])
중량구총확진자 = print(allobs[37])
기타총확진자 = print(allobs[38])

강남구오늘확진자 = print(allobs[13])
강동구오늘확진자 = print(allobs[14])
강북구오늘확진자 = print(allobs[15])
강서구오늘확진자 = print(allobs[16])
관악구오늘확진자 = print(allobs[17])
광진구오늘확진자 = print(allobs[18])
구로구오늘확진자 = print(allobs[19])
금천구오늘확진자 = print(allobs[20])
노원구오늘확진자 = print(allobs[21])
도봉구오늘확진자 = print(allobs[22])
동대문구오늘확진자 = print(allobs[23])
동작구오늘확진자 = print(allobs[24])
마포구오늘확진자 = print(allobs[25])
서대문구오늘확진자 = print(allobs[39])
서초구오늘확진자 = print(allobs[40])
성동구오늘확진자 = print(allobs[41])
성북구오늘확진자 = print(allobs[42])
송파구오늘확진자 = print(allobs[43])
양천구오늘확진자 = print(allobs[44])
영등포구오늘확진자 = print(allobs[45])
용산구오늘확진자 = print(allobs[46])
은평구오늘확진자 = print(allobs[47])
종로구오늘확진자 = print(allobs[48])
중구오늘확진자 = print(allobs[49])
중량구오늘확진자 = print(allobs[50])
기타오늘확진자 = print(allobs[51])

