import sys
#import pandas


class MyClass:
    i = 12345

    def f(self):
        return 'hello world'

def foo():
    a = 1
    b = MyClass()
    c = [1, 2, 3]
    #d = pandas.read_csv("my_file.csv")
    print_vars()

def print_vars():
    frame = sys._getframe()
    locals = frame.f_back.f_locals
    for el in locals.keys():
        value = locals.get(el)
        if value.__class__.__module__ == '__builtin__':
            print(el + ':' + ' True')
        else:
            print(el + ':' + ' False')
    
foo()
