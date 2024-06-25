// A_Max_Function
const max = (a: number, b: number): number => a > b ? a : b;

// B_Sorting_Array_Function
const sort = (array: number[]): number[] => array.sort((a, b) => a - b);

// C_Trim_String_Function {
const trimString = (input: string): string => input.trim();

// D_Filter_Even_Numbers_Function
const filterEvenNumbers = (array: number[]): number[] => array.filter(x => x % 2 === 0);

// E_Load_Async_Data_Function
const loadDataAsync = (url: string): Promise<string> => new Promise((resolve) => {
    setTimeout(() => {
        resolve(`Data from ${url}`);
    }, 1000);
});

// F_Json_Serialization_Function
const serializeToJson = (data: any): string => JSON.stringify(data);