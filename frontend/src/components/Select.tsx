interface ISelect {
  label: string;
  options: { value: string; label: string }[];
  placeholder: string;
  name?: string;
  onChange?: (value: string, query: string) => void;
  value?: string;
}

export const Select = ({
  label,
  options,
  placeholder,
  onChange,
  name,
  value,
}: ISelect) => {
  const onHandleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    if (!onChange || !name) return;
    onChange(event.target.value.toUpperCase(), name);
  };
  return (
    <div>
      <p className="text-2xl font-medium mb-2">{label}:</p>
      <select
        className="bg-white p-5 w-full rounded-lg shadow-md"
        defaultValue={value}
        onChange={onHandleChange}
      >
        <option value="" disabled>
          {placeholder}
        </option>
        {options.map((option, index) => (
          <option key={index} value={option.value}>
            {option.label}
          </option>
        ))}
      </select>
    </div>
  );
};
