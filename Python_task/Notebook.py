from datetime import datetime
from email.utils import parsedate_to_datetime
from genericpath import isfile
from operator import itemgetter
import os

def generalCommandList():
	print("Введите new для создания нового файла с заметками")
	print("Введите read для работы с существующим файлом")
	print("Введите exit для выхода из программы")

def noteCommandList():
	print("Введите 1 для создания новой заметки")
	print("Введите 2 для редактирования заметки")
	print("Введите 3 для удаления заметки")
	print("Введите 4 для вывода всех заметок")
	print("Введите 5 для вывода нужной заметки")
	print("Введите 6 для вывода заметок с учетом даты")
	print("Введите stop для выхода из редактора")

def dateSortCommandList():
	print("Введите 1 для сортировки по дате создания по убыванию")
	print("Введите 2 для сортировки по дате создания по возрастанию")
	print("Введите 3 для сортировки по дате изменения по убыванию")
	print("Введите 4 для сортировки по дате изменения по возрастанию")	
	print("Введите stop для выхода из редактора")

def fileManager():
	print("Введите имя файла: ")
	fileName = "Python_task/notes/" + input() + ".txt"
	return fileName

def createFile(fileName):	
	if os.path.isfile(fileName):
		return False
	else:
		file = open(fileName, 'x')
		file.close()
		readFile(fileName)
		return True	

def readFile(fileName):	
	if os.path.isfile(fileName):
		commandsManager(fileName)
		return True
	else:
	   return False

def parseFile(fileName):
	with open(fileName, 'r') as file:
		lines = file.readlines()	
	return lines

def parseNote(note):
	result = note.split("|")
	return result

def parseDate(date):
	result = date.split("=")
	return result

def createListOfDicts(fileName):
	notes = parseFile(fileName)
	result = list()
	for el in notes:
		note = parseNote(el)
		creation_date = parseDate(note[3])
		change_date = parseDate(note[4])
		dict_element = dict()
		dict_element['ID'] = note[0]
		dict_element['Заголовок'] = note[1]
		dict_element['Текст'] = note[2]
		dict_element[creation_date[0]] = datetime.strptime(creation_date[1], "%Y-%m-%d %H:%M:%S")
		dict_element[change_date[0]] = datetime.strptime(change_date[1], "%Y-%m-%d %H:%M:%S") 
		result.append(dict_element)
	return result

def newNote(fileName):
	notes = parseFile(fileName)
	date = datetime.today()
	print("Введите заголовок заметки: ")
	head = input()
	print("Введите текст заметки: ")
	body = input()
	date_string = date.strftime("%Y-%m-%d %H:%M:%S")
	notes.append(f"{len(notes) + 1}|{head}|{body}|Дата создания={date_string}|Дата последнего изменения={date_string}|" + "\n")
	with open(fileName, 'w') as file:
		for el in notes:			
			file.writelines(el)		

def changeNote(fileName):
	showNotes(fileName)
	note_number = int(input("Введите номер заметки: "))	
	notes = parseFile(fileName)
	if note_number <= len(notes):
		note = parseNote(notes[note_number - 1])
		print("Введите измененную заметку: ")
		note[2] = input()
		date = datetime.today()
		date_string = date.strftime("%Y-%m-%d %H:%M:%S")
		note[4] = f" Дата последнего изменения={date_string}| \n"
		notes[note_number - 1] = f"{note_number}|{note[1]}|{note[2]}|{note[3]}|{note[4]}"
		with open(fileName, 'w') as file:
			for el in notes:
				file.writelines(el)
	else:
		print("Номер заметки неправильный")

def deleteNote(fileName):
	showNotes(fileName)
	note_number = int(input("Введите номер заметки: "))
	notes = parseFile(fileName)	
	if note_number <= len(notes):
		notes.pop(note_number - 1)		
		for i in range(note_number - 1, len(notes)):
			note = parseNote(notes[i])
			notes[i] = f"{i + 1}|{note[1]}|{note[2]}|{note[3]}|{note[4]}|"			
		with open(fileName, 'w') as file:
			for el in notes:
				file.writelines(el)			
	else:
		print("Номер заметки неправильный")

def showNotes(fileName):
	notes = createListOfDicts(fileName)
	for el in notes:
		print(f"{el['ID']}. Заголовок: {el['Заголовок']} | Текст: {el['Текст']} | Дата создания: {el['Дата создания']} | Дата последнего изменения: {el['Дата последнего изменения']}")		

def altShowNotes(notes):
	for el in notes:
		print(f"{el['ID']}. Заголовок: {el['Заголовок']} | Текст: {el['Текст']} | Дата создания: {el['Дата создания']} | Дата последнего изменения: {el['Дата последнего изменения']}")		

def showNote(fileName):
	note_number = int(input("Введите номер заметки: "))
	notes = parseFile(fileName)
	if note_number <= len(notes):
		print(notes[note_number - 1])
	else:
		print("Номер заметки неправильный")		

def showByDate(fileName):	
	flag = True
	while flag:
		dateSortCommandList()
		notes = createListOfDicts(fileName)
		command = input()
		if command == "1":
			notes.sort(key=itemgetter('Дата создания'))
			altShowNotes(notes)
		elif command == "2":
			notes.sort(reverse=True, key=itemgetter('Дата создания'))
			altShowNotes(notes)
		elif command == "3":
			notes.sort(key=itemgetter('Дата последнего изменения'))
			altShowNotes(notes)
		elif command == "4":
			notes.sort(reverse=True, key=itemgetter('Дата последнего изменения'))
			altShowNotes(notes)
		elif command == "stop":
			flag = False
		else:
			print("Нет такой команды")
		


def commandsManager(fileName):		
	flag = True
	while flag:
		noteCommandList()
		command = input()
		if command == "1":
			newNote(fileName)
		elif command == "2":
			changeNote(fileName)
		elif command == "3":
			deleteNote(fileName)
		elif command == "4":
			showNotes(fileName)
		elif command == "5":
			showNote(fileName)
		elif command == "6":
			showByDate(fileName)
		elif command == "stop":
			flag = False
		else:
			print("Нет такой команды")

flag = True
while flag:
	generalCommandList()
	general_command = input().lower()
	if general_command == "new":
		if createFile(fileManager()):
			print("Файл создан")
		else:
			print("Такой файл уже есть")
	elif general_command == "read":
		if readFile(fileManager()):
			print("Файл найден")
		else:
			print("Такого файла нет")
	elif general_command == "exit":
		print("До свидания!")
		flag = False
	else:
		print("Нет такой команды")
	