The combination that performed best is optimal replacement with a configuration of
rss: 15 and npf: 3 because optimal replacement looks to replace elements that will 
not be used for the longest time in the future which results in the least page faults. 
The smaller frame size decreases the O(n) runtime because there are fewer slots to search 
for and therefore takes less time to determine whether the current element is present in
the array of frames or not.
