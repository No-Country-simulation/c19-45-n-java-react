interface IInput {
  label: string;
  type: string;
  placeholder: string;
  value?: string;
}
export const Input = ({ label, type, placeholder, value }: IInput) => {
  return (
    <div>
      <p className="text-2xl font-medium mb-2">{label}:</p>
      <input
        type={type}
        value={value}
        className="bg-white p-5 w-full rounded-lg shadow-md"
        placeholder={placeholder}
      />
    </div>
  );
};
