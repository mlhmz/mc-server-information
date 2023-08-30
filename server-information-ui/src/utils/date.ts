export const formatDate = (date: Date): string => {
    return date.toLocaleDateString() + " " + date.toLocaleTimeString();
}

export const parseIsoDate = (date: string): Date => {
    return new Date(Date.parse(date));
}