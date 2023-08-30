import { useCallback, useEffect, useState } from "react";
import { Information } from "../Information";

async function fetchInformation(): Promise<Information[]> {
  const response = await fetch("/api/v1/msi/informations");
  const data = await response.json();
  return data;
}

const useInformation = () => {
  const [data, setData] = useState<Information[]>([]);
  const [lastRefresh, setLastRefresh] = useState<Date>(new Date());

  const refresh = useCallback(async () => {
    const data = await fetchInformation();
    setData(data);
    setLastRefresh(new Date());
  }, []);

  useEffect(() => {
    refresh();
  }, [refresh]);

  return { data, refresh, lastRefresh };
};

export default useInformation;
