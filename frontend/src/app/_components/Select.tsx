interface ISelect {
  label: string;
  options: { value: string; label: string }[];
  placeholder: string;
}

export const Select = ({ label, options, placeholder }: ISelect) => {
  return (
    <div>
      <p className="text-2xl font-medium mb-2">{label}:</p>
      <select
        className="bg-white p-5 w-full rounded-lg shadow-md"
        defaultValue=""
      >
        <option value="" disabled hidden>
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
