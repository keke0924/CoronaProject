import pandas as pd

import pymysql
from selenium import webdriver
from selenium.webdriver.chrome.options import Options

options = Options()
options.add_argument('--kiosk')
chromedriver ='C:\cromedriver\chromedriver.exe'

driver = webdriver.Chrome(chromedriver, chrome_options=options)
driver.get('https://www.incheon.go.kr/health/HE020409')
driver.implicitly_wait(25)

table = driver.find_element_by_class_name('mob-scroll')
contents = table.find_elements_by_tag_name("ul > li > dl > dd")

allobs=[]
for content in contents:
    allobs.append(content.text.strip())
d = pd.DataFrame(columns = allobs)
#print(d)

중구총확진자 = print(allobs[2])
#용인총확진자 = print(allobs[3])
동구총확진자 = print(allobs[4])
#부천총확진자 = print(allobs[5])
미추홀구총확진자 = print(allobs[6])
#화성총확진자 = print(allobs[7])
연수구총확진자 = print(allobs[8])
#안양총확진자 = print(allobs[9])
남동구총확진자 = print(allobs[10])
#의정부총확진자 = print(allobs[11])
부평총확진자 = print(allobs[12])
#시흥총확진자 = print(allobs[13])
계양구총확진자 = print(allobs[14])
#광명총확진자 = print(allobs[15])
서구총확진자 = print(allobs[16])
#군포총확진자 = print(allobs[17])
강화군총확진자 = print(allobs[18])
#오산총확진자 = print(allobs[19])
옹진군총확진자 = print(allobs[20])
#양주총확진자 = print(allobs[21])
기타총확진자 = print(allobs[22])
"""안성총확진자 = print(allobs[23])
포천총확진자 = print(allobs[24])
의왕총확진자 = print(allobs[25])
여주총확진자 = print(allobs[26])
양평총확진자 = print(allobs[27])
동두천총확진자 = print(allobs[28])
과천총확진자 = print(allobs[29])
가평총확진자 = print(allobs[30])
연천총확진자 = print(allobs[31])"""

#중구총확진자 = print(allobs[2])
중구오늘확진자 = print(allobs[3])
#동구총확진자 = print(allobs[4])
동구오늘확진자 = print(allobs[5])
#미추홀구총확진자 = print(allobs[6])
미추홀구오늘확진자 = print(allobs[7])
#연수구총확진자 = print(allobs[8])
연수구오늘확진자 = print(allobs[9])
#남동구총확진자 = print(allobs[10])
남동구오늘진자 = print(allobs[11])
#부평총확진자 = print(allobs[12])
부평구오늘확진자 = print(allobs[13])
#계양구총확진자 = print(allobs[14])
계양구오늘확진자 = print(allobs[15])
#서구총확진자 = print(allobs[16])
서구오늘확진자 = print(allobs[17])
#강화군총확진자 = print(allobs[18])
강화군오늘확진자 = print(allobs[19])
#옹진군총확진자 = print(allobs[20])
옹진군오늘확진자 = print(allobs[21])
#기타총확진자 = print(allobs[22])
기타오늘확진자 = print(allobs[23])

driver.close()