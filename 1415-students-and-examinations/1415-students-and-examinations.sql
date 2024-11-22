SELECT 
    st.student_id, 
    st.student_name, 
    sb.subject_name, 
    COUNT(em.subject_name) AS attended_exams
FROM 
    Students AS st
CROSS JOIN 
    Subjects AS sb
LEFT JOIN 
    Examinations AS em 
ON 
    st.student_id = em.student_id 
    AND sb.subject_name = em.subject_name
GROUP BY 
    st.student_id, st.student_name, sb.subject_name
ORDER BY st.student_id,sb.subject_name;
