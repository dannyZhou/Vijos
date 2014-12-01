program  tyvj1037;
  var  t,n,m,i,j : longint;
       b : array[0..1400000] of boolean;
       r : array[0..1400000] of longint;
       ss : string;
       ans,l : int64;
  begin
    readln(n,m);
    l := 1; ans := 1;
    for i := 1 to m do l := l * 10;
    for i := 1 to n do r[i] := i;
    fillchar(b,sizeof(b),1); t := 0;
    for i := 2 to n do
      if b[i] then
        for j := 1 to n div i do
          begin
            b[i*j] := false;
            while r[i*j] mod i = 0 do
              begin
                r[i*j] := r[i*j] div i;
                if i=2 then inc(t) else
                if i=5 then dec(t) else
                  ans := int64(ans) * int64(i) mod l;
              end;
          end;
    for i := 1 to t do
       ans := ans * 2 mod l;
    str(ans,ss);
    while length(ss)<m do ss := '0' + ss;
    writeln(ss);
  end.
