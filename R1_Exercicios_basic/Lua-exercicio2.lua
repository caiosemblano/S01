local lista = {5, 2, 9, 1, 5}
-- local n = io.read("*n")
-- table.insert(lista, n)

local maior = lista[1]

for i, valor in ipairs(lista) do
    if valor > maior then
        maior = valor
    end
end

print(maior)

