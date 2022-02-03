const colors = require('tailwindcss/colors')

module.exports = {
  content: ['./src/pages/**/*.tsx', './src/components/**/*.tsx'],
  theme: {
    colors: {
      transparent: 'transparent',
      current: 'currentColor',
      black: colors.black,
      white: colors.white,
      gray: colors.gray,
      blue: colors.blue,
      primary: 'var(--color-primary)',
      secondary: 'var(--color-secondary)',
      tertiary: 'var(--color-tertiary)',
      success: 'var(--color-success)',
      error: 'var(--color-error)',
      textDark: 'var(--color-text-dark)',
      textMuted: 'var(--color-text-muted)',
      textGray: 'var(--color-text-gray)',
      textGreen: 'var(--color-text-green)',
      textYellow: 'var(--color-text-yellow)',
      gray99: 'var(--color-gray99)',
      'blue-dark': '#223a78',
      'blue-light': '#4d9aec',
      'blue-gray': '#878DBA',
      'gray-base': '#8b8b8b',
      'gray-dark': '#323438',
      'gray-light': '#d3d3d3',
      'gray-lightest': '#fafafa',
      'green-base': '#0ABE5D',
      'green-light': '#9af98b',
      'red-base': '#f31629',
      'red-light': '#FF8A80',
      'gray-medium': '#A9A9A9'
    },
    extend: {
      spacing: {
        128: '28rem',
        133: '33.813rem',
        138: '38.125rem'
      },
      fontSize: {
        xxs: '0.625rem',
        medium: ['20px', '29px']
      }
    }
  },
  plugins: []
}