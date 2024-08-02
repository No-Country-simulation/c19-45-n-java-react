"use client";

interface IInput {
  label: string;
  type: string;
  placeholder: string;
  value?: string;
  onChange?: (value: string, query: string) => void;
  name?: string;
}
export const Input = ({
  label,
  type,
  placeholder,
  value,
  onChange = () => {},
  name = "",
}: IInput) => {
  const onHandleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    if (!onChange || !name) return;
    onChange(event.target.value, name);
  };
  return (
    <div>
      <p className="text-2xl font-medium mb-2">{label}:</p>
      <input
        type={type}
        value={value}
        className="bg-white p-5 w-full rounded-lg shadow-md"
        placeholder={placeholder}
        onChange={onHandleChange}
        defaultValue={value}
      />
    </div>
  );
};
