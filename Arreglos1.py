class arreglos1:
    def __init__(self):
        self.departamentos = ["Ropa", "Deporte", "Jugueteria"]
        self.ventas = {departamento: [0] * 12 for departamento in self.departamentos}

    def agregar_venta(self, departamento, mes, cantidad):
        if departamento in self.ventas and 1 <= mes <= 12:
            self.ventas[departamento][mes - 1] += cantidad

    def buscar_venta(self, departamento, mes):
        if departamento in self.ventas and 1 <= mes <= 12:
            return self.ventas[departamento][mes - 1]
        return None

    def eliminar_ventas(self, departamento):
        if departamento in self.ventas:
            self.ventas[departamento] = [0] * 12

    def mostrar_ventas(self):
        for departamento, ventas in self.ventas.items():
            print(f"Ventas de {departamento}:")
            for mes, cantidad in enumerate(ventas, start=1):
                print(f"  Mes {mes}: {cantidad} unidades")

# Ejemplo de uso
tienda = arreglos1()

# Agregar ventas 
while True:
    departamento = input("Ingrese el departamento (Ropa, Deporte, Jugueteria) o 'salir' para terminar: ")
    if departamento.lower() == 'salir':
        break
    mes = int(input("Ingrese el mes (1-12): "))
    cantidad = int(input("Ingrese la cantidad de ventas: "))
    tienda.agregar_venta(departamento, mes, cantidad)

# Buscar una venta específica
departamento = input("Ingrese el departamento para buscar una venta: ")
mes = int(input("Ingrese el mes para buscar una venta (1-12): "))
venta = tienda.buscar_venta(departamento, mes)
print(f"Ventas en {departamento} para el mes {mes}: {venta} unidades")

# Eliminar ventas de un departamento
departamento = input("Ingrese el departamento para eliminar todas las ventas: ")
tienda.eliminar_ventas(departamento)

# Mostrar todas las ventas
print("Ventas después de las operaciones:")
tienda.mostrar_ventas()
