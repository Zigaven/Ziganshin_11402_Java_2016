import os
import random
import sys
import time
import telepot
port = int(os.environ.get("PORT", 5000))
from telepot.namedtuple import ReplyKeyboardMarkup, KeyboardButton, ReplyKeyboardRemove, ForceReply

chats = {}




def on_chat_message(msg):
    content_type, chat_type, chat_id = telepot.glance(msg)
    print("weaegtdrhhrt")

    if chat_id not in chats.keys():
        chats[chat_id] = ""
        print("___ " + str(len(chats)) + " ___ users now")

    if msg['text'] == "/start":
        bot.sendMessage(chat_id, "Your chat ID: " + str(chat_id))
    elif chats[chat_id] == "":
        chats[chat_id] = msg['text']
    else:
        bot.sendMessage(chat_id, 'No please')


TOKEN = "586715397:AAGOCEMPP9s5qNGLT1G1aNdrJ1NOFeA5Yj0"

bot = telepot.Bot(TOKEN)


bot.message_loop({'chat': on_chat_message})
print('Listening ...')

while True:
    time.sleep(10)