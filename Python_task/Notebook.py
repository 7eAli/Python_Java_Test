from datetime import datetime
from genericpath import isfile
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
		result = list()
		for el in lines:
			result.append(el)		
	return result

def parseNote(note):
	result = note.split("|")
	return result

def newNote(fileName):
	notes = parseFile(fileName)
	date = datetime.today()
	print("Введите текст заметки: ")
	date_string = date.strftime("%Y-%m-%d_%H:%M:%S")
	notes.append(f"{len(notes) + 1} | {input()} | {date_string} | Даты изменений: |" + "\n")
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
		note[1] = input()
		date = datetime.today()
		date_string = date.strftime("%Y-%m-%d_%H:%M:%S")
		note[3] += f"{date_string} | \n"
		notes[note_number - 1] = f"{note_number} | {note[1]} |{note[2]}|{note[3]}"
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
			notes[i] = f"{i + 1} |{note[1]}|{note[2]}|{note[3]}|{note[4]}"			
		with open(fileName, 'w') as file:
			for el in notes:
				file.writelines(el)			
	else:
		print("Номер заметки неправильный")

def showNotes(fileName):
	notes = parseFile(fileName)	
	for el in notes:
		print(el)		

def showNote(fileName):
	note_number = int(input("Введите номер заметки: "))
	notes = parseFile(fileName)
	if note_number <= len(notes):
		print(notes[note_number - 1])
	else:
		print("Номер заметки неправильный")

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
	