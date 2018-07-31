for k,v in ipairs(KEYS) do 	    
	local vals=redis.call('hgetall',v)
	 --Lua5.3 table.getn->rawlen
	for i=2,table.getn(vals),2 do
		redis.call('hset',ARGV[k],vals[i-1],vals[i])
	end
end
return 1

