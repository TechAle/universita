# TODO MAKE SECOND TERMINAL FOR LINUX

## 1.5
## bug fixing + improving
from selenium import webdriver
## for enter
from selenium.webdriver.common.keys import Keys
## for waits and time
import time
## for store information
import json
## for password
import hashlib
## for check the email
from validate_email import validate_email
## for crypting
from cryptography.fernet import Fernet
## for config file
from configparser import ConfigParser
## for random tag
import random
## for log
import logging
## for get the plantform
import sys
## for start script
import os
## for multiple threading (automatic bot)
from threading import Thread
from queue import Queue


## for bypass
bypass = '0'

Debug = 0



## global variable

uff_tags = ['citazione','amore','solitudine']



## dati

dati = \
    [

    ]

## possibility
possibility = \
    [
        'p',
        'r',
        'l'
    ]


## count
num = 0

## tag

tag = []

## list time + what they do

lista = []

## dictionary

dati_url = ConfigParser()

## plantform

plant = ''

## account

## functions

## get plantform for exec path
def path_create():
    if plant == 'mac':
        return "/usr/local/bin/geckodriver"
    elif plant == 'win':
        return "C:\Program Files (x86)\Microsoft Visual Studio\Shared\Python37_64\geckodriver.exe"

## get os
def os_get_():
    if sys.platform == 'darwin':
        return 'mac'
    elif sys.platform == 'win32':
        return 'win'
    else:
        return 'lin'

## load data

def load():
    ## open and read
    global dati_url
    ## load json on the dictionary
    try:
        dati_url.read('./Data/dati.data')
    except:
        logging.error('file dati.data didnt found')
        os.close()
    ## for account
    global account_exist
    ## load crypt
    with open('./Data/crypt.data', 'r') as f:
        ## if it's empty
        if len(f.read()) == 0:
            account_exist = 0
            ## make it different
            passw = 0
            passw2 = 1
            while passw != passw2:
                ## insert password
                passw = input('insert a password (you can disable it after this message)')
                passw2 = input('re-insert the password')
                ## confront if arent the same
                if passw != passw2:
                    print('passwords are not the same')
            ## remove?
            if input('do you want remove the password? (y/n)')[0] == 'y':
                bypass = 'this_is_a_secret'
            ## add password to file
            with open('./Data/crypt.data', 'w') as r:
                ## add the key for the crypt
                r.write('{},{}\n{}'.format(hashlib.sha256(str.encode(passw2)).hexdigest(), bypass, Fernet.generate_key()))
        ## controll the password
        else:
            account_exist = 1
            ## open the file for save the data
            with open('./Data/crypt.data', 'r') as t:
                ## read password and bypass
                provaaa = t.readline().split(',')
                password_hash = provaaa[0]
                bypass = provaaa[1].replace('\n','')
                ## read crypt
                key = t.readline()
                global _Crypt
                ## make it byte + fernet
                _Crypt = Fernet(_Cryptogr.f_str_b(key))
            ## controll if the sha of Bypass isnt the same of the key
            if hashlib.sha256(str.encode(bypass)).hexdigest() != '06282fd37afcaf863d4b8d5d00141d71094b92cc730fdc030376ae95eacf0866':
                ## load password from file
                choose = '0'
                ## continue util choose == password
                while choose != password_hash:
                    ## take an input and transform in his sha
                    choose = hashlib.sha256(str.encode(input('insert the password'))).hexdigest()
                    ## controll if arent the same
                    if choose != password_hash:
                        print('password wrong, please wait')
                        waits(3)
                    else:
                        print('password is correct')
    ## dati (tag, time, accounts)
    with open('./Data/dati_pers.data', 'r') as ra:
        empty = ra.read()
    ## controll if isnt empty
    if empty != '':
        with open('./Data/dati_pers.data','r') as r_a:
            ## controll tag
            prova = r_a.readline().split()
            global tag
            tag = [_Cryptogr.f_b_str(i) for i in prova]
            ## controll lista
            global lista
            prova = r_a.readline().split()
            lista = [_Cryptogr.f_b_str(i) for i in prova]
            ## controll dati
            global dati
            dati = []
            prova = r_a.readline().split()
            ind = 0
            for i in range(len(prova)):
                if i % 2 == 0:
                    dati.append({})
                    dati[ind]['email'] = _Cryptogr.f_b_str(prova[i])
                else:
                    dati[ind]['password'] =_Cryptogr.f_b_str(prova[i])
                    ind += 1



## function input with range
def rich_num(sentec, max):
    ## initialization num1
    num1 = 0
    ## if < or > (range)
    while num1 < 1 or num1 > max:
        num1 = round(int(input(sentec)),0)
        if num1 < 1 or num1 > max:
            print("invalid number (1-{})".format(max))
    return num1

## function for checking the css is ok (if not the connection is poor)
def ric_check_css(path,choose,text,bot,id,error_):

    for i in range(5):
        waits(2)
        try:
            ## check id
            if id == 0:
                path_ck = bot.find_element_by_id(path)
            ## check class
            else:
                path_ck = bot.find_element_by_class_name(path)
            ## choose text
            if choose == 0:
                ## clear for prevention
                path_ck.clear()
                ## press enter
                send.text(path_ck,text)
                waits(0.1)
                send.enter(path_ck)
            ## choose button
            else:
                path_ck.click()
            return 1
        except:
            logging.warn('error {}'.format(error_))
    return 0

class send:
## click enter
    def enter(path):
        ## click enter on path
        path.send_keys(Keys.RETURN)

    ## send_text
    def text(path,text):
        ## left click on path
        path.send_keys(text)

## waits
def waits(seconds):
    time.sleep(seconds)

## menu

class menu:

    def first():
        return rich_num("1) start bot\n2) add/remove tags\n3) set time\n4) settings\n5) save\n6) quit",6)

    def timer():
        return input('choose when it will post and when it will like/reblog some post. write \'no\' for dont reset previusly settings (1 p / 1 l / 1 r / no)\ninsert x for exit').split()

    def settings():
        return rich_num('1) go to post settings\n2) list of all accounts\n3) quit',3)

    def account():
        return rich_num('1) add account\n2) remove an account\n3) quit',3)

    def bot_m():
        return rich_num('1) like post\n2) reblog\n3) time post\n4) automac bot\n5) post',5)

    def file_control_m():
        return rich_num("1) force like\n2) force reblog\n3) force post\n4) exit",4)


## classes

## control date
class contr_date():
    def first(self,date):
        if str.isnumeric(date[0]):
            ## check lenght
            first = date.split(':')[0]
            if len(date) == 5:
                second = date.split(':')[1]
            elif len(date) == 2:
                second = '00'
            if len(first) == 2 and len(second) == 2:
                ## check if it exist
                if int(first) >= 0 and int(first) <= 24 and int(second) >= 0 and int(second) <= 60:
                    return 1
                else:
                    ## error date dont exist
                    print('date must be >= 1 and <= 24 (hour) 60 (minute)')
            else:
                ## error lenght
                print('date must be length 2/4 (yes 16:00 no 1600:0)')
        else:
            ## error letter
            print('date cannot be componed by some letter! ')
        return 0

    def letter(self,letter_):
        global possibility
        if letter_[0] in possibility:
            return 1
        else:
            return 0

    def after(self,date,lenght):
        if str.isnumeric(date[0]):
            ## check lenght
            first = date.split(':')[0]
            if len(date) == 5:
                second = date.split(':')[1]
            elif len(date) == 2:
                second = '00'
            ## remove
            elif len(first) == 1:
                if int(date) > lenght:
                    print('number is too big (max {})'.format(lenght))
                    return 0
                elif int(date) < 1:
                    print('number is too small (min 1)')
                    return 0
                else:
                    return 2
            else:
                print('date must be lenght 2/4 (yes 16:00 no 1600:0)')
                return 0
            # check if it exist
            if int(first) >= 0 and int(first) <= 24 and int(second) >= 0 and int(second) <= 60:
                return 1
            else:
                ## error date dont exist
                print('date must be >= 1 and <= 24 (hour) 60 (minute)')
        else:
            print('date cannot be componed by some letter! ')
        return 0

    def analyz(self,date_, when,len_,mode):
        ## analyze date
        if mode == 0:
            prova1 = contr_date.first(self,date_)
        else:
            prova1 = contr_date.after(self,date_,len_)
        if prova1 == 1:
            ## analyze letter
            prova2 = contr_date.letter(self,when)
            if prova2 == 1:
                global lista
                lista.append('{},{}'.format(date_, when))

## now time
def now_time():
    now = time.asctime().split()[3].split(':')
    print("now it's {}:{}".format(now[0], now[1]))

## crypt help class

class _Cryptogr:
    def f_str_b(sents):
        return bytes(sents[sents.find('\'')+1:-1],'utf-8')
    def str_b_f(sents):
        return str(_Crypt.encrypt(bytes(sents, 'utf-8')))
    def f_b_str(sents):
        sent = str(_Crypt.decrypt(_Cryptogr.f_str_b(sents)))
        return sent[sent.find('\'')+1:-1]

## input time
class input_time:
    def first():
        ## remove all duplicate + input
        return input('choose when the bot will go (ex 15:30 p 10:00 r) ').split()
    ## input other time
    def other():
        return input('choose when the bot will go (ex 15:30 p 10:00 r) and, if you want remove some, digit his number (1 - 15:15, 2 - 11:11) ').split()



class TumblrBot:
    ## initialization
    def __init__(self):
        global plant
        ## load data
        logging.info('loading data')
        load()
        ## start firefox

        try:
            if plant != 'win':
                self.bot = webdriver.Firefox(executable_path = path_create(), log_path='./Log/gekodrive.log')
            else:
                self.bot = webdriver.Firefox(executable_path= path_create(),service_log_path='.\Log\gekodrive.log')
        except:
            print('error in line 311, controll the executable path')
            logging.error('error line 311, executable error path: {}'.format(path_create()))
            quit()
        logging.info('started bot without error')
        ## se non ci sta nessuna email
        self.num = account_exist
        print(self.bot.find_elements_by_class_name('prova'))
        ## se dati[0] è soltanto {}
        if not dati:
            ## chiedere quante email
            self.num = rich_num("how many email do you want? ", 5)
        ## inizio loop aggiunta
            for i in range(self.num):
                ## aggiungere dizionari
                dati.append({})
                ## inserire gli input
                dati[i]['email'],dati[i]['password'] = TumblrBot.Settings_main.req_account(self)
                dati[i]['email'],dati[i]['password'] = 'alessandro.condello.email@gmail.com','prova_tumblr'
        self.Start_main.start(self)

    class Start_main():

        ## start iniziale
        def start(self):
            self.bot.get(dati_url['url']['login'])
            time.sleep(3)
            if self.bot.current_url == dati_url['url']['login']:
                TumblrBot.Start_main.login(self)
            elif self.bot.current_url == dati_url['url']['concent']:
                self.bot.find_element_by_class_name(dati_url['url']['concent']).click()
                waits(1)
                TumblrBot.Settings_main(self)
            else:
                TumblrBot.inizio(self)

        ## function login
        def login(self):
            logging.info('start login')
            ## for make less length
            bot = self.bot
            ## initializazion choose
            choose = 0
            ## check if there are more than 1 email
            if self.num > 1:
                print("which email would you use?, \nemails are these:")
                ## print all the email
                for i in range(self.num):
                    print("n^{} {}".format(i+1,dati[i]['email']))
                choose = rich_num("decide which email use ",self.num)-1
            else:
                scelte = 1
            ## send_enter path in email e password
            email_ins = dati[choose]['email']
            passw_ins = dati[choose]['password']
            ## entering date
            if not ric_check_css(dati_url['id_login']['email'],0,email_ins,bot,0,'email ins'):
                logging.error('the page didnt load')
                sys.exit()
            # email_path = bot.find_element_by_id(dati_url['id_login']['email'])
            # ## clear
            # email_path.clear()
            # ## start email
            # ## insert email in path
            # send.text(email_path,email_ins)
            # ## press enter
            # send.enter(email_path)
            # ## loading
            # waits(2)
            ## remove 2 process (magic link)
            if not ric_check_css(dati_url['id_login']['go_password'],1,'',bot,1,'go to pass'):
                logging.error('the page didnt load')
                sys.exit()
            #
            # proc2 = bot.find_element_by_class_name(dati_url['id_login']['go_password'])
            # proc2.click()
            # ## loading
            # waits(2)
            ## password
            ## same for email
            if not ric_check_css(dati_url['id_login']['password'],0,passw_ins,bot,0,'passw ins'):
                logging.error('the page didnt load')
                sys.exit()

            # password_path = bot.find_element_by_id(dati_url['id_login']['password'])
            # password_path.clear()
            # send.text(password_path,passw_ins)
            # send.enter(password_path)
            ## change page
            time.sleep(3)
            ## check for the captcha
            if(bot.current_url == dati_url['url']['captcha']):
                self.captcha()
            else:
                TumblrBot.inizio(self)

        def captcha(self,passw_ins):
            logging.info('captcha found')
            ## same of precedent
            password_path = self.bot.find_element_by_id(dati_url['id_login']['password'])
            password_path.clear()
            send.text(password_path,passw_ins)
            password_path.send_keys(data['password'])
            print("complete the captcha")
            ## wait util url change
            TumblrBot.waiting(self)
            TumblrBot.inizio(self)




    ## start with bot
    def inizio(self):
        logging.info('start menu')
        ## print
        choose = 0
        while not choose == 6:
            print(lista)
            choose = menu.first()
            ## start bot
            if choose == 1:
                TumblrBot.Bot_Class(self.bot)
            ## add tag
            elif choose == 2:
                TumblrBot.tags(self)
            ## time
            elif choose == 3:
                TumblrBot.Settings_main.timer(self)
            ## setting
            elif choose == 4:
                TumblrBot.Settings_main.menu(self)
            ## save
            elif choose == 5:
                TumblrBot.save(self)
            ## quit
            elif choose == 6:
                TumblrBot.save(self)
                if Debug == 0:
                    self.bot.close()



    ## settings main

    class Settings_main:

        def menu(self):

            ## choose
            choose = menu.settings()
            ## settings time
            if choose == 1:
                TumblrBot.Settings_main.timer(self)
            ## settings account
            elif choose == 2:
                TumblrBot.Settings_main.account(self)
        ## settings account
        def account(self):
            ## make global the account ist
            print('list account:')
            ## print al accounts
            for i in range(len(dati)):
                print('{} {} {}'.format(i+1, dati[i]['email'],dati[i]['password']))
            ## input
            choose = menu.account()
            ## add an account
            if choose == 1:
                ## request email+password
                email,password = TumblrBot.Settings_main.req_account(self)
                ## adding email+password
                dati.append({'email': email, 'password': password})
            elif choose == 2:
                ## check if the len of account list is > 1
                if len(dati) > 1:
                    print('list: ')
                    ## stamp all the accounts
                    for i in range(len(dati)):
                        print('{} {} {}'.format(i + 1, dati[i]['email'], dati[i]['password']))
                    ## input the numbers
                    choose_2 = rich_num('write the number of the email you would remove',len(dati))
                    ## analyze
                    for i in range(choose_2):
                        if len(dati) > 1:
                            ## if choose is <= len(account_list) for dont go overflow
                            if choose_2[i] <= len(dati):
                                dati.pop(i-1)






        ## settings post timer
        def timer(self):
            a = 0
            global tag
            ## check if time and tags are created
            if not tag:
                print('the tags havent been made, please add some')
                a += 1
                TumblrBot.tags(self)
            ## if they have been created
            if not a:
                global lista
                ## if lista isnt never created
                if not lista:
                    time_text = input_time.first()
                    ## start
                    for i in range(int(len(time_text) / 2)):
                        j = i * 2
                        contr_date.analyz(self,time_text[j], time_text[j + 1],0,0)
                else:
                    time_text = input_time.other()
                    ## print all time
                    for i in range(len(lista)):
                        print('{} {}'.format(i+1, lista[i]))
                    ## n^even number input
                    for i in range(int(len(time_text) / 2)):
                        j = i * 2
                        contr_date.analyz(self,time_text[j], time_text[j + 1],len(lista),1)
                lista = list(set(lista))



        def req_account(self):
            a = 1
            while a:
                email = input('insert an email')
                ## check if the email exist
                if validate_email(email,check_mx=True):
                    a = 0
                else:
                    print('email dont exist')
            password = input('insert a password')
            return email,password











    def tags(self):
        ## check if tag directory is empty
        global tag
        if not tag:
            tag_contr = input('there arent any tag, please add some tag').split()
            first = 0
            for i in range(len(tag_contr)):
                ## check if contain a number
                if str.isnumeric(tag_contr[i]):
                    print('number cant be added!')
                ## else add to directory
                else:
                    if first == 0:
                        tag.append(tag_contr[0])
                        first += 1
                    else:
                        tag.append(tag_contr[i])
                        tag = list(set(tag))
                        print(tag)
        else:
            ## print all tags
            for i in range(len(tag)):
                print('{} {}'.format(i + 1, tag[i]))
            ## input
            tag_contr = input("for remove some tag, write his number\nfor add, just write the tag ").split()
            ## inspect
            for i in range(len(tag_contr)):
                ## remove
                if str.isnumeric(tag_contr[i][0]):
                    ## control the lenght
                    if int(tag_contr[i][0]) > len(tag):
                        print("{} contain a number too big".format(i + 1))
                    ## if it's ok
                    else:
                        tag.pop(int(tag_contr[i][0]) - 1)
                ## add
                else:
                    tag.append(tag_contr[i])
                    tag = list(set(tag))
    ## save tag, time, accounts
    def save(self):
        ## first tag, after time and after accounts
        with open('./Data/dati_pers.data', 'w') as file_w:
            logging.info('start saving data')
            ## first line
            for i in tag:
                file_w.write(_Cryptogr.str_b_f(i))
                file_w.write(' ')
            file_w.write('\n')
            ## second line
            logging.info('saved tags')
            for i in lista:
                file_w.write(_Cryptogr.str_b_f(i))
                file_w.write(' ')
            file_w.write('\n')
            logging.info('saved lista')
            ## final line
            for i in range(len(dati)):
                file_w.write(_Cryptogr.str_b_f(dati[i]['email']))
                file_w.write(' ')
                file_w.write(_Cryptogr.str_b_f(dati[i]['password']))
                file_w.write(' ')
            logging.info('saved accounts')



    ## wait util url change
    def waiting(self):
        start_url = self.bot.current_url
        while start_url == self.bot.current_url:
            time.sleep(1)

    class Bot_Class:
        def __init__(self,bot):
            self.bot = bot
            ## controll tag and time_post
            if tag:
                ## input the choose
                choose = menu.bot_m()
                ## analyze choose
                if choose == 1:
                    ## start like
                    TumblrBot.Bot_Class.like(self)
                elif choose == 2:
                    ## start reblog
                    TumblrBot.Bot_Class.reblog(self)
                elif choose == 3:
                    ## settings time_post
                    TumblrBot.Settings_main.timer(self)
                elif choose == 4:
                    ## automatic bot
                    TumblrBot.Bot_Class.automatic_bot_start(self)
                elif choose == 5:
                    ## post
                    TumblrBot.Bot_Class.post_create(self)




            ## error tag + time post == NULL
            else:
                print('make some tags and time')

        ## automatic bot
        def automatic_bot_start(self):
            logging.info('start bot')
            ## Thread
            que = Queue()
            t_req = Thread(target=lambda q, : q.put(TumblrBot.Bot_Class.Controll()), args=(que, ))
            t_req.start()
            ## settings varialbe
            force = 0

            while force != 4:
                ## create time
                time_now = ':'.join(time.asctime().split()[3].split(':')[:2])
                ## controll all time (lista contains all time)
                for i in lista:
                    if time_now == i.split(',')[0]:
                        choose_ = i.split(',')[1]
                        ## analyze
                        if choose_ == 'l':
                            logging.info('start like')
                            TumblrBot.Bot_Class.like(self)
                        elif choose_ == 'r':
                            logging.info('start reblog')
                            TumblrBot.Bot_Class.reblog(self)
                        elif choose_ == 'p':
                            logging.info('start post')
                            TumblrBot.Bot_Class.post_create(self)
                ## check thread request
                if(not t_req.is_alive()):
                    ## get output
                    result = que.get()
                    force = int(result)
                    ## controll force
                    if force == 1:
                        TumblrBot.Bot_Class.like(self)
                    elif force == 2:
                        TumblrBot.Bot_Class.reblog(self)
                    elif force == 3:
                        TumblrBot.Bot_Class.post_create(self)
                    if force != 4:
                        ## reset
                        force = 0
                        t_req = Thread(target=lambda q,: q.put(TumblrBot.Bot_Class.Controll()), args=(que,))
                        t_req.start()


            ## finish
            self.bot.get(dati_url['url']['dashboard'])

        def Controll():
            return menu.file_control_m()



        ## bot like
        def like(self):
            ## create link
            TumblrBot.Bot_Class.page_tag(self)
            ## like
            TumblrBot.Bot_Class.make(self,'like')

        ## bot reblog
        def reblog(self):
            ## create link
            TumblrBot.Bot_Class.page_tag(self)
            #reblog
            TumblrBot.Bot_Class.make(self,'reblog')

        ## create link page
        def page_tag(self):
            ## create link + go to link
            link = dati_url['url']['search'] + tag[random.randint(0,len(tag)-1)] + dati_url['url']['search2']
            self.bot.get(link)
            waits(1)

        def make(self,option):
            ## get all post
            all_post = self.bot.find_elements_by_class_name(dati_url['id_login'][option])[:int(dati_url['config'][option + '_pass']) * 2]
            i = 0
            end = 0
            ## while util finish
            while end != int(dati_url['config'][option + '_pass']):
                ## controll if liked/reblogged
                if all_post[i].get_attribute('class') == dati_url['class'][option]:
                    all_post[i].click()
                    end += 1
                    ## for reblog
                    if option == 'reblog':
                        waits(2)
                        self.bot.find_element_by_class_name(dati_url['id_login']['reblog_button']).click()

                    waits(int(dati_url['config']['delay']))
                i += 1
        # add a post




        def post_create(self):
            ## create post
            ## click post
            self.bot.find_element_by_class_name(dati_url['id_login']['post_create']).click()
            waits(1)
            ## click citation
            self.bot.find_element_by_class_name(dati_url['id_login']['post_button_cit']).click()
            waits(1)
            ## create text
            with open('./Text/sentenc.txt', 'r+') as f:
                ## read all lines
                f_l = f.readlines()
                ## pointer to 0
                f.seek(0)
                ## write
                for cont, item in enumerate(f_l):
                    if cont != 0:
                        f.write(item)
                    else:
                        text = item
            ## send text
            send.text(self.bot.find_element_by_class_name(dati_url['id_login']['post_text']),text)
            ## create tags
            global uff_tags
            for i in uff_tags:
                ## take the path
                path_ = self.bot.find_elements_by_class_name(dati_url['id_login']['post_text'])
                ## send text and load it
                send.text(path_[2],i)
                waits(0.2)
                send.enter(path_[2])
                waits(0.2)
            ## post it
            self.bot.find_element_by_class_name(dati_url['id_login']['post_button']).click()


if __name__ == "__main__":

    ## check os

    plant = os_get_()

    ## settings logging


    begin = ''
    path_ = './Log/{}.log'
    if time.asctime().split(':')[0].split()[3].__contains__('0'):
        begin = '0'
    win_begin = 1


    time__ = begin + ('_'.join(time.asctime().split(' ')[2:-1])[win_begin:]).replace(':','_')
    print(time__)
    logging.basicConfig(filename=path_.format(time__), level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
    if plant == 'mac' or plant == 'lin':
        os.system('open ./Log/{}.log'.format(time__))


    def main():
        logging.info('start bot without debug mode one')
        inizio = TumblrBot()
    if Debug != 1:
        main()
    else:
        logging.info('start bot with debug mode one')
        load()
        TumblrBot.inizio(1)
