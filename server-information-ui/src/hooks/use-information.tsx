import { useCallback, useState } from "react";
import { Information } from "../Information";

async function fetchInformation(): Promise<Information[]> {
    const response = await fetch("/api/v1/msi/informations");
    const data = await response.json();
    return data;
}

const useInformation = () => {
    const [data, setData] = useState<Information[]>([]);

    const refresh = useCallback(async () => {
        const data = await fetchInformation();
        setData(data);
    }, []);

    return { data, refresh };
};

export default useInformation;