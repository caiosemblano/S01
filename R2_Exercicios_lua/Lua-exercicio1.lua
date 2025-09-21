local m = io.read("*n")
local n = io.read("*n")
local x = io.read("*n")

local i = math.ceil(m / x)

while i * x <= n do
  print(i * x)
  i = i + 1
end




