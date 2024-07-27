
interface Props extends React.LabelHTMLAttributes<HTMLLabelElement> {}

export  function Label({ children, ...props }: Props) {
  return (
    <label
      className="block text-2xl font-semibold leading-6 text-black m-3"
      {...props}
    >
      {children}
    </label>
  );
}

export default Label;
