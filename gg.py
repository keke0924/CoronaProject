import pandas as pd
import requests
from bs4 import BeautifulSoup
import pymysql
from selenium import webdriver

chromedriver ='C:\cromedriver\chromedriver.exe'

driver = webdriver.Chrome(chromedriver)
driver.get('https://www.gg.go.kr/contents/contents.do?ciIdx=1150&menuId=2909')
driver.implicitly_wait(15)



table = driver.find_element_by_class_name('mt-4.zone')
contents = table.find_elements_by_tag_name("dd > strong")

allobs=[]
for content in contents:
    allobs.append(content.text.strip())
d = pd.DataFrame(columns = allobs)
#print(d)



수원총확진자 = print(allobs[1])
고양총확진자 = print(allobs[2])
용인총확진자 = print(allobs[3])
성남총확진자 = print(allobs[4])
부천총확진자 = print(allobs[5])
안산총확진자 = print(allobs[6])
화성총확진자 = print(allobs[7])
남양주총확진자 = print(allobs[8])
안양총확진자 = print(allobs[9])
평택총확진자 = print(allobs[10])
의정부총확진자 = print(allobs[11])
파주총확진자 = print(allobs[12])
시흥총확진자 = print(allobs[13])
김포총확진자 = print(allobs[14])
광명총확진자 = print(allobs[15])
광주총확진자 = print(allobs[16])
군포총확진자 = print(allobs[17])
이천총확진자 = print(allobs[18])
오산총확진자 = print(allobs[19])
하남총확진자 = print(allobs[20])
양주총확진자 = print(allobs[21])
구리총확진자 = print(allobs[22])
안성총확진자 = print(allobs[23])
포천총확진자 = print(allobs[24])
의왕총확진자 = print(allobs[25])
여주총확진자 = print(allobs[26])
양평총확진자 = print(allobs[27])
동두천총확진자 = print(allobs[28])
과천총확진자 = print(allobs[29])
가평총확진자 = print(allobs[30])
연천총확진자 = print(allobs[31])


table = driver.find_element_by_class_name('mt-4.zone')
contents = table.find_elements_by_class_name("count")

allobs=[]
for content in contents:
    allobs.append(content.text.strip())
d = pd.DataFrame(columns = allobs)
#print(d)

수원오늘확진자 = print(allobs[1])
고양오늘확진자 = print(allobs[2])
용인오늘확진자 = print(allobs[3])
성남오늘확진자 = print(allobs[4])
부천오늘확진자 = print(allobs[5])
안산오늘확진자 = print(allobs[6])
화성오늘확진자 = print(allobs[7])
남양주오늘확진자 = print(allobs[8])
안양오늘확진자 = print(allobs[9])
평택오늘확진자 = print(allobs[10])
의정부오늘확진자 = print(allobs[11])
파주오늘확진자 = print(allobs[12])
시흥오늘확진자 = print(allobs[13])
김포오늘확진자 = print(allobs[14])
광명오늘확진자 = print(allobs[15])
광주오늘확진자 = print(allobs[16])
군포오늘확진자 = print(allobs[17])
이천오늘확진자 = print(allobs[18])
오산오늘확진자 = print(allobs[19])
하남오늘확진자 = print(allobs[20])
양주오늘확진자 = print(allobs[21])
구리오늘확진자 = print(allobs[22])
안성오늘확진자 = print(allobs[23])
포천오늘확진자 = print(allobs[24])
의왕오늘확진자 = print(allobs[25])
여주오늘확진자 = print(allobs[26])
양평오늘확진자 = print(allobs[27])
동두천오늘확진자 = print(allobs[28])
과천오늘확진자 = print(allobs[29])
가평오늘확진자 = print(allobs[30])
연천오늘확진자 = print(allobs[31])