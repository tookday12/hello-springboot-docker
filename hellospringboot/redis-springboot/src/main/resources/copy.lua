for k,v in ipairs(KEYS) do 	    
	local val=redis.call('get',v)
	redis.call('set',ARGV[k],val)
end
return 1

