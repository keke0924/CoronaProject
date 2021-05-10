# 실시간 문자 크롤링
# 미완성 코드.. 더 추가/수정 해주세요~!

import pandas as pd
import requests
from bs4 import BeautifulSoup
import pymysql
from selenium import webdriver

chromedriver ='C:\cromedriver\chromedriver.exe'

driver = webdriver.Chrome(chromedriver)
driver.get('https://m.news.naver.com/covid19/live.nhn')
driver.implicitly_wait(15)



table = driver.find_element_by_class_name('mlp_message_list_area')
contents = table.find_elements_by_tag_name("li")


allobs=[]
for content in contents:
    allobs.append(content.text.strip())
d = pd.DataFrame(columns = allobs)
print(d)
#a = print(allobs[0]) # 가장 최근문자 출력
