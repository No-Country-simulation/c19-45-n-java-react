interface ITextarea {
  label: string;
  placeholder: string;
}

export const Textarea = ({ label, placeholder }: ITextarea) => {
  return (
    <div>
      <p className="text-2xl font-medium mb-2">{label}</p>
      <textarea
        className="bg-white p-5 w-full rounded-lg shadow-md"
        placeholder={placeholder}
      />
    </div>
  );
};
