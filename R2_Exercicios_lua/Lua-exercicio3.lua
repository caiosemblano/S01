function filtrarPares(tabela)
    local tabelaPares = {}
    for i = 1, #tabela do
        local numero = tabela[i]
        if numero % 2 == 0 then
            table.insert(tabelaPares, numero)
        end
    end
    return tabelaPares
end

function exibirTabela(tabela, nome)
    print(nome .. ":")
    if #tabela == 0 then
        print("  (vazia)")
    else
        for i = 1, #tabela do
            print("  " .. i .. ": " .. tabela[i])
        end
    end
    print()
end

local numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
local numerosPares = filtrarPares(numeros)
exibirTabela(numerosPares, "Nova tabela (apenas números pares)")
