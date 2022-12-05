import re

stack1Char = ['G', 'D', 'V', 'Z', 'J', 'S', 'B']
stack2Char = ['Z', 'S', 'M', 'G', 'V', 'P']
stack3Char = ['C','L','B','S','W','T','Q','F']
stack4Char = ['H','J','G','W','M','R','V','Q']
stack5Char = ['C','L','S','N','F','M','D']
stack6Char = ['R','G','C','D']
stack7Char = ['H','G','T','R','J','D','S','Q']
stack8Char = ['P','F','V']
stack9Char = ['D','R','S','T','J']

stackList = [stack1Char, stack2Char, stack3Char, stack4Char, stack5Char, stack6Char, stack7Char, stack8Char, stack9Char]

def move(list1, list2, times):
  list2.extend(list1[-times:])
  del list1[-times:]

def getTopOfStack():
  with open("input.txt", "r") as f:
    for line in f:
      curr = re.findall(r'\d+', line)
      move(stackList[int(curr[1]) - 1], stackList[int(curr[2]) - 1], int(curr[0]))
  res = ""
  res += stack1Char.pop()
  res += stack2Char.pop()
  res += stack3Char.pop()
  res += stack4Char.pop()
  res += stack5Char.pop()
  res += stack6Char.pop()
  res += stack7Char.pop()
  res += stack8Char.pop()
  res += stack9Char.pop()

  print(res)

getTopOfStack()
