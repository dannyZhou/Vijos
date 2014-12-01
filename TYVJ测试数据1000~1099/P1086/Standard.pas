//By ะกัล
program ex;
var
 f:Array[0..40000] of boolean ;
 h,c,a:array[1..400] of longint ;
 n,i,j,k,m:longint ;

procedure ch(x,y:longint) ;
var
 t:longint ;
begin
 t := a[x] ;
 a[x] := a[y] ;
 a[y] := t ;
 t := h[x] ;
 h[x] := h[y] ;
 h[y] := t ;
 t := c[x] ;
 c[x] := c[y] ;
 c[y] := t ;
end ;

procedure qsort(l,r:longint) ;
var
 i,j,x:longint ;
begin
 i := l ;
 j := r ;
 x := a[(l+r) shr 1] ;
 repeat
  while a[i] < x do inc(i) ;
  while a[j] > x do dec(j) ;
  if i <= j then
   begin
    ch(i,j) ;
    inc(i) ;
    dec(j) ;
   end ;
 until i > j ;
 if i < r then qsort(i,r) ;
 if l < j then qsort(l,j) ;
end ;

BEGIN
 read(n) ;
 for i := 1 to n do
  read(h[i],a[i],c[i]) ;
 qsort(1,n) ;
 fillchar(f,sizeof(f),false) ;
 f[0] := true ;
 m := 0 ;
 for i := 1 to n do
  for j := m downto 0 do
   if (j <= 40000) and f[j] then
    for k := 1 to c[i] do
     if j+k*h[i] <= a[i] then
      begin
       f[j+k*h[i]] := true ;
       if j+k*h[i] > m then m := j+k*h[i] ;
      end ;
 writeln(m) ;
END .
