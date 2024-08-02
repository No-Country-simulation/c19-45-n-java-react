interface IInput {
  label: string;
  type: string;
  placeholder: string;
}
export const Input = ({ label, type, placeholder }: IInput) => {
  return (
    <div>
      <p className="text-2xl font-medium mb-2">{label}:</p>
      <input
        type={type}
        className="bg-white p-5 w-full rounded-lg shadow-md"
        placeholder={placeholder}
      />
    </div>
  );
};
